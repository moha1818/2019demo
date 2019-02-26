package com.sunland.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.sunland.dao.*;
import com.sunland.dto.BussinessInfo;
import com.sunland.dto.InvoiceDate;
import com.sunland.dto.Items;
import com.sunland.dto.MoneyDto;
import com.sunland.exception.BadRequestException;
import com.sunland.exception.BizException;
import com.sunland.pojo.InvoiceElectronic;
import com.sunland.pojo.InvoiceElectronicInfo;
import com.sunland.pojo.InvoiceElectronicItem;
import com.sunland.pojo.json.CreateInvoiceJson;
import com.sunland.pojo.json.HeaderInfo;
import com.sunland.service.InvoiceElectronicService;
import com.sunland.support.mybatis.BaseCRUDServiceImpl;
import com.sunland.utils.AES128;
import com.sunland.utils.HttpUtil;
import com.sunland.utils.ParamUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class InvoiceElectronicServiceImpl extends BaseCRUDServiceImpl<InvoiceElectronic> implements InvoiceElectronicService {
    private static final String BASEURL = ParamUtils.getParametersString("INVOICE_BASEURL");
    @Resource
    private InvoiceElectronicMapper invoiceElectronicMapper;

    @Resource
    private InvoiceElectronicItemMapper invoiceElectronicItemMapper;

    @Resource
    private InvoiceElectronicInfoMapper invoiceElectronicInfoMapper;

    @Resource
    private TBusinessMapper tBusinessMapper;

    @Resource
    private TParkpotBusinessMapper tParkpotBusinessMapper;

    @Override
    public HeaderInfo selectHeaderInfoByAccountId(Integer accountId) {
        return invoiceElectronicMapper.selectHeaderInfoByAccountId(accountId);
    }

    @Override
    public List<HeaderInfo> selectHeaderInfoByname(String name) {
        String url = BASEURL+"/bill/query/querytitles?access_token="+AES128.accessToken()+"&name="+name;
        String result = HttpUtil.doGet(url,null,null,"UTF-8",true);
        JSONObject json = JSONObject.parseObject(result);
        List<HeaderInfo> headerInfos = JSONObject.parseArray(json.getString("data"),HeaderInfo.class);
        return headerInfos;
    }

    private Items count(double totalAmountInt,double taxrate,MoneyDto moneyDto){
        BigDecimal totalAmountTemp = new BigDecimal(totalAmountInt/100).setScale(2,RoundingMode.HALF_UP);
        BigDecimal totalAmount = moneyDto.getTotalAmount().add(totalAmountTemp).setScale(2,RoundingMode.HALF_UP);
        String totalAmountStr = totalAmountTemp.toString();

        BigDecimal taxAmountTemp = totalAmountTemp.divide(new BigDecimal(1+taxrate/100),2,RoundingMode.HALF_UP).multiply(new BigDecimal(taxrate/100)).setScale(2,RoundingMode.DOWN);
        BigDecimal taxAmount = moneyDto.getTaxAmount().add(taxAmountTemp);
        String taxAmountStr = taxAmountTemp.toString();

        BigDecimal invoiceAmount = totalAmount.subtract(taxAmount);

        moneyDto.setTaxAmount(taxAmount);
        moneyDto.setInvoiceAmount(invoiceAmount);
        moneyDto.setTotalAmount(totalAmount);

        //路内税率10%
        Items items = new Items();
        items.setDetailAmount(totalAmountStr);
        items.setTaxRate(String.valueOf(taxrate/100));
        items.setTaxAmount(taxAmountStr);
        return items;
    }


    @Override
    public InvoiceDate saveInvoice(CreateInvoiceJson createInvoiceJson, InvoiceElectronicInfo invoiceElectronicInfo) {
        List<String> list = invoiceElectronicInfo.getUuids();
        String[] uuids = new String[list.size()];
        uuids = list.toArray(uuids);
        List<BussinessInfo> bussinessInfoList = new ArrayList<>();
        List<Items> itemsList = new ArrayList<>();
        MoneyDto moneyDto = new MoneyDto();
        //路内
        if(invoiceElectronicInfo.getType() == 1){
            bussinessInfoList = tBusinessMapper.selectparkpointBusinessByuuids(uuids);
            Integer totalAmountInt = bussinessInfoList.stream().mapToInt(BussinessInfo::getPayment).sum();

            //路内税率10%
            Items items = count(totalAmountInt,10,moneyDto);
            itemsList.add(items);
            String invoiceAmountStr = moneyDto.getInvoiceAmount().toString();
            createInvoiceJson.setInvoiceAmount(invoiceAmountStr);
            createInvoiceJson.setTotalAmount(moneyDto.getTotalAmount().toString());
            createInvoiceJson.setTotalTaxAmount(moneyDto.getTaxAmount().toString());
        }else if(invoiceElectronicInfo.getType() == 2){
            bussinessInfoList = tParkpotBusinessMapper.selectparkpotBusinessByuuids(uuids);
            List<BussinessInfo> tax10 = bussinessInfoList.stream().filter(a -> a.getTaxrate() == 10).collect(Collectors.toList());
            List<BussinessInfo> tax5 = bussinessInfoList.stream().filter(a -> a.getTaxrate() == 5).collect(Collectors.toList());
            List<BussinessInfo> filter = bussinessInfoList.stream().filter(a->!a.getParkpotid().equals(invoiceElectronicInfo.getParkpotid())).collect(Collectors.toList());
            if(filter.size()>0){
                throw new BadRequestException("请务必提交同个停车场的业务数据");
            }

            if(tax10.size() > 0){
                Integer totalAmountInt = tax10.stream().mapToInt(BussinessInfo::getPayment).sum();
                Items items = count(totalAmountInt,10,moneyDto);
                itemsList.add(items);
            }
            if(tax5.size() > 0){
                Integer totalAmountInt = tax5.stream().mapToInt(BussinessInfo::getPayment).sum();
                Items items = count(totalAmountInt,5,moneyDto);
                itemsList.add(items);
            }
            String invoiceAmountStr = moneyDto.getInvoiceAmount().toString();
            createInvoiceJson.setInvoiceAmount(invoiceAmountStr);
            createInvoiceJson.setTotalAmount(moneyDto.getTotalAmount().toString());
            createInvoiceJson.setTotalTaxAmount(moneyDto.getTaxAmount().toString());
        }

        createInvoiceJson.setItems(itemsList);
        String json = null;
        try {
            json = AES128.encrypt1(JSONObject.toJSONString(createInvoiceJson));
        } catch (Exception e) {
            throw new BizException("加密异常");
        }
        JSONObject jsonObject = AES128.doPost(BASEURL+"/m5/bill/invoice/create?access_token="+AES128.accessToken(),json);
        String resultCode = jsonObject.getString("errcode");
        InvoiceDate invoiceDate = jsonObject.getObject("data", InvoiceDate.class);
        if("0000".equals(resultCode)){
            //开票成功
            InvoiceElectronic invoiceElectronic = new InvoiceElectronic();
            invoiceElectronic.setAccountid(invoiceElectronicInfo.getAccountid());
            invoiceElectronic.setSerialno(invoiceDate.getSerialNo());
            //发票金额（不含税）
            invoiceElectronic.setInvoiceamount(moneyDto.getInvoiceAmount());
            invoiceElectronic.setTotaltaxamount(moneyDto.getTaxAmount());
            invoiceElectronic.setTotalamount(moneyDto.getTotalAmount());
            invoiceElectronic.setInvoicetype(Byte.valueOf(createInvoiceJson.getType()));
            invoiceElectronic.setBusinesstype(invoiceElectronicInfo.getType());
            invoiceElectronic.setInvoicecode(invoiceDate.getInvoiceCode());
            invoiceElectronic.setInvoiceno(invoiceDate.getInvoiceNo());
            invoiceElectronic.setPdfurl(invoiceDate.getPdfUrl());
            invoiceElectronic.setStatus(1);
            invoiceElectronic.setContent("停车费");
            invoiceElectronic.setParkpotid(invoiceElectronicInfo.getParkpotid());
            invoiceElectronicMapper.insertSelective(invoiceElectronic);

            invoiceElectronicInfo.setEid(invoiceElectronic.getEid());
            invoiceElectronicInfoMapper.insertSelective(invoiceElectronicInfo);

            List<InvoiceElectronicItem> invoiceElectronicItems = new ArrayList<>();
            for(BussinessInfo bussinessInfo:bussinessInfoList){
                InvoiceElectronicItem item = new InvoiceElectronicItem();
                item.setEid(invoiceElectronic.getEid());
                item.setHphm(bussinessInfo.getHphm());
                item.setParkmoney(new BigDecimal((double)bussinessInfo.getPayment()/100).setScale(2,RoundingMode.HALF_UP));
                item.setParkname(bussinessInfo.getParkname());
                item.setParktime(bussinessInfo.getParktime());
                item.setUuid(bussinessInfo.getUuid());
                invoiceElectronicItems.add(item);
            }
            invoiceElectronicItemMapper.insertList(invoiceElectronicItems);
            Map<String,Object> map = new HashMap<>();
            map.put("invoicestate",1);
            map.put("invoiceno",invoiceDate.getInvoiceNo());
            map.put("invoicecode",invoiceDate.getInvoiceCode());
            map.put("uuid",uuids);
            if(invoiceElectronicInfo.getType() == 1){
                tBusinessMapper.updateBusinessByuuid(map);
            }else if(invoiceElectronicInfo.getType() == 2){
                tParkpotBusinessMapper.updateBusinessByuuid(map);
            }

        }
        return invoiceDate;
    }

    public static void main(String[] args) {
        BigDecimal bigDecimal = new BigDecimal(1500/100);
        double r = 10;
        BigDecimal b = new BigDecimal((double)5850/100).setScale(2,RoundingMode.HALF_UP);
        bigDecimal = bigDecimal.divide(new BigDecimal(1+r/100),RoundingMode.HALF_UP).multiply(new BigDecimal(0.1)).setScale(2,RoundingMode.HALF_UP);
        String taxAmountStr = bigDecimal.toString();
        System.out.println(b);
        System.out.println(taxAmountStr);
    }





}

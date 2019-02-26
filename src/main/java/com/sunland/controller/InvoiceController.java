package com.sunland.controller;

import com.github.pagehelper.PageInfo;
import com.sunland.dto.InvoiceDate;
import com.sunland.dto.RestResponse;
import com.sunland.exception.BadRequestException;
import com.sunland.exception.PermissionException;
import com.sunland.pojo.InvoiceElectronic;
import com.sunland.pojo.InvoiceElectronicInfo;
import com.sunland.pojo.InvoiceElectronicItem;
import com.sunland.pojo.json.*;
import com.sunland.service.InvoiceElectronicInfoService;
import com.sunland.service.InvoiceElectronicItemService;
import com.sunland.service.InvoiceElectronicService;
import com.sunland.utils.ParamUtils;
import io.swagger.annotations.*;
import joptsimple.internal.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/invoice/")
@Api(tags="发票业务" ,description="发票业务描述")
public class InvoiceController {

    @Autowired
    private InvoiceElectronicService invoiceElectronicService;

    @Autowired
    private InvoiceElectronicInfoService invoiceElectronicInfoService;

    @Autowired
    private InvoiceElectronicItemService invoiceElectronicItemService;

    private final static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    @ApiOperation(value = "开票信息页-抬头信息初始化",notes = "[@moha]")
    @RequestMapping(value = "/toCreate",method = RequestMethod.GET)
    @ResponseBody
    public RestResponse<HeaderInfo> toCreate(@ApiParam(value = "微信-utoken,安卓IOS-mobilenum")@RequestParam String token,@ApiParam(value = "设备：IOS，Android，WX")@RequestParam String deviceId,HttpServletRequest request, HttpServletResponse response){
        Integer accountId = (Integer) request.getSession().getAttribute("accountId");
        return new RestResponse<HeaderInfo>(invoiceElectronicService.selectHeaderInfoByAccountId(accountId));
    }

    @ApiOperation(value = "提交开票信息页",notes = "[@moha]")
    @RequestMapping(value = "/create",method = RequestMethod.POST)
    @ResponseBody
    public RestResponse<InvoiceDate> create(@ApiParam(value = "微信-utoken,安卓IOS-mobilenum")@RequestParam String token, @ApiParam(value = "设备：IOS，Android，WX")@RequestParam String deviceId, @RequestBody @Valid InvoiceElectronicInfo invoiceElectronicInfo, HttpServletRequest request, BindingResult bindingResult){
        Integer accountId = (Integer) request.getSession().getAttribute("accountId");
        invoiceElectronicInfo.setAccountid(accountId);
        if(invoiceElectronicInfo.getBuyertype() == 1){
            if(Strings.isNullOrEmpty(invoiceElectronicInfo.getBuyertaxno())){
                throw new BadRequestException("企业开票税号必填");
            }
        }
        if(invoiceElectronicInfo.getType() == null){
            throw new BadRequestException("业务类型必传");
        }

        if(invoiceElectronicInfo.getType() == 2){
            if(Strings.isNullOrEmpty(invoiceElectronicInfo.getParkpotid())){
                throw new BadRequestException("停车场发票停车场ID必传");
            }
        }

        CreateInvoiceJson createInvoiceJson = new CreateInvoiceJson();
        int i= new Random().nextInt(900)+100;
        String serialstr = invoiceElectronicInfo.getType() == 1?"TCD":"TCC";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String date = simpleDateFormat.format(new Date());
        createInvoiceJson.setSerialNo(serialstr+date+i);
        createInvoiceJson.setTaxFlag("1");
        createInvoiceJson.setInventoryFlag("0");
        createInvoiceJson.setInventoryProjectName("0");
        createInvoiceJson.setType("0");
        createInvoiceJson.setBuyerFixedTelephone(invoiceElectronicInfo.getBuyertelephone());
        createInvoiceJson.setBuyerAddress(invoiceElectronicInfo.getBuyeraddress());
        createInvoiceJson.setBuyerName(invoiceElectronicInfo.getBueyrname());
        createInvoiceJson.setBuyerTaxNo(invoiceElectronicInfo.getBuyertaxno());
        createInvoiceJson.setBuyerAccount(invoiceElectronicInfo.getBuyeraccount());
        createInvoiceJson.setBuyerMobilePhone(invoiceElectronicInfo.getBuyermobilephone());

        //收款人
        createInvoiceJson.setDrawer(ParamUtils.getParametersString("INVOICE_DRAWER"));
        //复核人
        createInvoiceJson.setReviewer(ParamUtils.getParametersString("INVOICE_REVIEWER"));
        createInvoiceJson.setPayee(ParamUtils.getParametersString("INVOICE_PAYEE"));
        createInvoiceJson.setRemark(invoiceElectronicInfo.getRemark());
        InvoiceDate invoiceDate = invoiceElectronicService.saveInvoice(createInvoiceJson,invoiceElectronicInfo);
        return new RestResponse<>(invoiceDate);
    }


    @ApiOperation(value = "查询抬头信息",notes = "[@moha]")
    @RequestMapping(value = "/query",method = RequestMethod.GET)
    @ResponseBody
    public RestResponse<List<HeaderInfo>> query(@ApiParam(value = "微信-utoken,安卓IOS-mobilenum")@RequestParam String token,@ApiParam(value = "设备：IOS，Android，WX")@RequestParam String deviceId,@ApiParam(value = "企业名称")@RequestParam String name){
        if(Strings.isNullOrEmpty(name)){
            new RestResponse<List<HeaderInfo>>(null);
        }
        List<HeaderInfo> list = invoiceElectronicService.selectHeaderInfoByname(name);
        if(list != null && list.size()>0){
            list = list.stream().limit(3).collect(Collectors.toList());
        }

        return new RestResponse<List<HeaderInfo>>(list);
    }

    @ApiOperation(value = "查询开票记录列表",notes = "[@moha]")
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @ResponseBody
    public RestResponse<PageInfo<InvoiceElectronic>> list(@ApiParam(value = "微信-utoken,安卓IOS-mobilenum")@RequestParam String token, @ApiParam(value = "设备：IOS，Android，WX")@RequestParam String deviceId, @ApiParam(value = "1-路内停车 2-停车场")@RequestParam Integer businessType,@ApiParam(value = "页码")@RequestParam Integer pageNum,HttpServletRequest request) throws Exception {
        Integer accountId = (Integer) request.getSession().getAttribute("accountId");
        PageInfo pageInfo = new PageInfo();
        pageInfo.setPageSize(5);
        pageInfo.setPageNum(pageNum);
        InvoiceElectronic invoiceElectronic = new InvoiceElectronic();
        invoiceElectronic.setAccountid(accountId);
        invoiceElectronic.setBusinesstype(businessType);
        invoiceElectronicService.selectPage(pageInfo,invoiceElectronic,"createdate DESC");
        return new RestResponse<PageInfo<InvoiceElectronic>>(pageInfo);
    }

    @ApiOperation(value = "开票记录详情",notes = "[@moha]")
    @RequestMapping(value = "/detail",method = RequestMethod.GET)
    @ResponseBody
    public RestResponse<InvoiceDetail> detail(@ApiParam(value = "发票id")@RequestParam Integer id,@ApiParam(value = "微信-utoken,安卓IOS-mobilenum")@RequestParam String token, @ApiParam(value = "设备：IOS，Android，WX")@RequestParam String deviceId,HttpServletRequest request){
        InvoiceDetail invoiceDetail = new InvoiceDetail();
        InvoiceElectronic invoiceElectronic = invoiceElectronicService.selectByPrimaryKey(id);
        if(invoiceElectronic == null){
            throw new BadRequestException("找不到发票");
        }
        Integer accountId = (Integer) request.getSession().getAttribute("accountId");
        if(invoiceElectronic.getAccountid() != accountId){
            throw new PermissionException("此用户没有权限查看该发票");
        }
        invoiceDetail.setAmount(invoiceElectronic.getTotalamount().toString());
        invoiceDetail.setId(invoiceElectronic.getEid());
        invoiceDetail.setCreateTime(sdf.format(invoiceElectronic.getCreatedate()));
        invoiceDetail.setStatus(invoiceElectronic.getStatus());
        invoiceDetail.setPdfUrl(invoiceElectronic.getPdfurl());

        InvoiceElectronicInfo invoiceElectronicInfo = new InvoiceElectronicInfo();
        invoiceElectronicInfo.setEid(id);
        invoiceElectronicInfo = invoiceElectronicInfoService.selectOne(invoiceElectronicInfo);
        invoiceDetail.setName(invoiceElectronicInfo.getBueyrname());

        InvoiceElectronicItem invoiceElectronicItem = new InvoiceElectronicItem();
        invoiceElectronicItem.setEid(id);
        int quantity = invoiceElectronicItemService.selectCount(invoiceElectronicItem);
        invoiceDetail.setQuantity(quantity);

        return new RestResponse<InvoiceDetail>(invoiceDetail);
    }

    @ApiOperation(value = "开票记录详情项",notes = "[@moha]")
    @RequestMapping(value = "/detail/items",method = RequestMethod.GET)
    @ResponseBody
    public RestResponse<List<InvoiceElectronicItem>> items(@ApiParam(value = "发票id")@RequestParam Integer id,@ApiParam(value = "微信-utoken,安卓IOS-mobilenum")@RequestParam String token, @ApiParam(value = "设备：IOS，Android，WX")@RequestParam String deviceId,HttpServletRequest request){
        InvoiceElectronic invoiceElectronic = invoiceElectronicService.selectByPrimaryKey(id);
        if(invoiceElectronic == null){
            throw new BadRequestException("找不到发票");
        }
        Integer accountId = (Integer) request.getSession().getAttribute("accountId");
        if(!invoiceElectronic.getAccountid().equals(accountId)){
            throw new PermissionException("此用户没有权限查看该发票");
        }
        InvoiceElectronicItem invoiceElectronicItem = new InvoiceElectronicItem();
        invoiceElectronicItem.setEid(id);
        List<InvoiceElectronicItem> items = invoiceElectronicItemService.select(invoiceElectronicItem);
        return new RestResponse<List<InvoiceElectronicItem>>(items);
    }


}

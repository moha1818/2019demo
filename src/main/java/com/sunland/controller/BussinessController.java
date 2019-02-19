package com.sunland.controller;

import com.github.pagehelper.PageInfo;
import com.sunland.dto.RestResponse;
import com.sunland.exception.BadRequestException;
import com.sunland.pojo.json.PaymentList;
import com.sunland.service.TBusinessService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/business/")
@Api(tags="开票订单业务" ,description="开票订单描述")
public class BussinessController {

    @Autowired
    private TBusinessService tBusinessService;

    @ResponseBody
    @RequestMapping(value = "/getlist",method = RequestMethod.GET)
    @ApiOperation(value = "查询订单明细",notes = "[@moha]")
    public RestResponse<PageInfo<PaymentList>> selectBusiness(@ApiParam(value = "页码")@RequestParam Integer pageNum,@ApiParam(value = "微信-utoken,安卓IOS-mobilenum")@RequestParam String token, @ApiParam(value = "设备：IOS，Android，WX")@RequestParam String deviceId, @ApiParam(value = "1-路停 2-停车场")@RequestParam int type) throws Exception {
        String method = type==1?"selectBussinessList":"selectParkpotBussinessList";
        PageInfo pageInfo = new PageInfo();
        pageInfo.setPageSize(5);
        pageInfo.setPageNum(pageNum);
        if("IOS".equals(deviceId) || "Android".equals(deviceId)){
            Map param = new HashMap<>();
            param.put("mobilenum",token);
            PageInfo<PaymentList> listPageInfo = tBusinessService.selectPage(pageInfo,method,param);
            pageInfo = listPageInfo;
        }else if("WX".equals(deviceId)){
            Map param = new HashMap<>();
            param.put("utoken",token);
            PageInfo<PaymentList> listPageInfo = tBusinessService.selectPage(pageInfo,method,param);
            pageInfo = listPageInfo;
            //list = tBusinessService.selecBussinessList("",token,type);
        }else {
            throw new BadRequestException("not found device");
        }
        return new RestResponse<>(pageInfo);
    }

}

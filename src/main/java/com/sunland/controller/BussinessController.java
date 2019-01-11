package com.sunland.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/business/")
@Api(tags="开票订单业务" ,description="开票订单描述")
public class BussinessController {

    @ResponseBody
    @RequestMapping(value = "/getlist",method = RequestMethod.GET)
    @ApiOperation(value = "查询订单明细",notes = "[@moha]")
    public String selectBusiness(@ApiParam(value = "1-路停 2-停车场")@RequestParam int type, @ApiParam(value = "微信-token 安卓IOS-mobilenum")@RequestParam String token_id, @ApiParam(value = "客户端")@RequestParam String from){

        return "";
    }

}

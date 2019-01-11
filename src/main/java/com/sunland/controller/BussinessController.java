package com.sunland.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/business/")
@Api(tags="开票订单业务" ,description="开票订单描述")
public class BussinessController {

    @ResponseBody
    @RequestMapping(value = "/getlist",method = RequestMethod.GET)
    @ApiOperation(value = "查询订单明细",notes = "[@moha]")
    public String selectBusiness(@RequestParam(name = "1-路停 2-停车场") int type, @RequestParam(name = "微信-token 安卓IOS-mobilenum") String token_id, @RequestParam(name = "客户端")String from){

        return "";
    }

}

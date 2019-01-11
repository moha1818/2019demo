package com.sunland.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.sunland.dto.RestResponse;
import com.sunland.pojo.TestDemo;
import com.sunland.service.TestDemoService;
import com.sunland.utils.EnvUtils;
import io.swagger.annotations.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/invoice/")
@Api(tags="发票业务" ,description="发票业务描述")
public class InvoiceController {

    @Autowired
    private TestDemoService testDemoService;

    @ApiOperation(value = "保存个人信息",notes = "[@moha]")
    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    @ResponseBody
    public RestResponse<Integer> test(@RequestBody TestDemo testDemo){
        testDemoService.insertSelective(testDemo);
        return new RestResponse<Integer>(1);
    }

    @RequestMapping(value = "/selectInfo", method = RequestMethod.GET)
    @ResponseBody
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "系统错误"),
            @ApiResponse(code = 200, message = "0 成功,其它为错误")})
    @ApiOperation(httpMethod = "GET",value = "获取个人信息",notes = "[@moha]")
    public RestResponse<TestDemo> listCompound(@ApiParam(required = false, name = "userName", value = "名称模糊查询") @RequestParam String userName) {
        TestDemo testDemo = testDemoService.selectByPrimaryKey(1);
        String s = EnvUtils.getProperty("piaozone.com");
        System.out.println(s);
        return new RestResponse<TestDemo>(testDemo);
    }
}

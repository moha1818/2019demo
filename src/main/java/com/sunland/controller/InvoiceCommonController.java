package com.sunland.controller;

import com.alibaba.fastjson.JSONObject;
import com.sunland.dto.RestResponse;
import com.sunland.exception.BizException;
import com.sunland.pojo.json.PdfUrl;
import com.sunland.utils.AES128;
import com.sunland.utils.ParamUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/common/")
@Api(tags="发票API" ,description="内务业务调用API，不用身份验证")
public class InvoiceCommonController {
    private static final String BASEURL = ParamUtils.getParametersString("INVOICE_BASEURL");

    @ApiOperation(value = "电子发票pdf+快照",notes = "[@moha]")
    @RequestMapping(value = "/invoice/pdf",method = RequestMethod.GET)
    @ResponseBody
    public RestResponse<PdfUrl> pdfUrl(@RequestParam String serialNo){
        String url = BASEURL+"/m7/bill/invoice/serialno/pdf/query?access_token="+ AES128.accessToken();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("serialNo",serialNo);
        String result = "";
        try {
            result = AES128.encrypt1(JSONObject.toJSONString(jsonObject));
        } catch (Exception e) {
            throw new BizException("加密异常");
        }
        JSONObject object = AES128.doPost(url,result);
        PdfUrl pdfUrl = object.getObject("data", PdfUrl.class);
        return new RestResponse<>(pdfUrl);
    }

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    @ResponseBody
    public String ac(){
        return "1";
    }
}

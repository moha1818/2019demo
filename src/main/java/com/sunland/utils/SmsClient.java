package com.sunland.utils;


import org.apache.axis.client.Call;
import org.apache.axis.client.Service;

import javax.xml.namespace.QName;

/**
 * Created by wangc on 2016/7/1.
 */
public class SmsClient {
    private static String url = "http://172.18.6.172/hxyw/services/smsService?wsdl";
    private static String method = "sendSm";

    public static String sendSm(Object[] obj) {
        String ret = "";
        try {
            Service service = new Service();
            Call call = (Call) service.createCall();
            call.setOperationName(new QName(url, method));
            call.setTargetEndpointAddress(new java.net.URL(url));
            call.setUseSOAPAction(true);
            ret = (String) call.invoke(obj);
        } catch (Exception e) {
            ret = "1";
        }
        return ret;
    }

    public static void main(String[] args) {
        Object[] obj = new Object[]{"18668348510", "短信webServices接口测试", "", "01"};
        String ret = sendSm(obj);
        System.out.println(ret);
    }
}






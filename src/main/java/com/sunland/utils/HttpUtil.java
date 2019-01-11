package com.sunland.utils;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

/**
 * HTTP工具类
 * 发送http/https协议get/post请求，发送map，json，xml，txt数据
 * @author happyqing
 * @since 2017-04-08
 */
public final class HttpUtil {

    private static Log log = LogFactory.getLog(HttpUtil.class);

    /**
     * 执行一个http/https get请求，返回请求响应的文本数据
     *
     * @param url		请求的URL地址，可以带参数?param1=a&parma2=b
     * @param headerMap	请求头参数map，可以为null
     * @param paramMap	请求参数map，可以为null
     * @param charset	字符集
     * @param pretty	是否美化
     * @return 			返回请求响应的文本数据
     */
    public static String doGet(String url, Map<String, String> headerMap, Map<String, String> paramMap, String charset, boolean pretty) {
        //StringBuffer contentSb = new StringBuffer();
        String responseContent = "";
        // http客户端
        CloseableHttpClient httpclient = null;
        // Get请求
        HttpGet httpGet = null;
        // http响应
        CloseableHttpResponse response = null;
        try {

            if(url.startsWith("https")){
                httpclient = HttpsSSLClient.createSSLInsecureClient();
            } else {
                httpclient = HttpClients.createDefault();
            }

            // 设置参数
            if (paramMap != null) {
                List <NameValuePair> nvps = new ArrayList <NameValuePair>();
                for (Map.Entry<String, String> entry : paramMap.entrySet()) {
                    nvps.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
                }
                //EntityUtils.toString(new UrlEncodedFormEntity(nvps, charset));
                url = url + "?" + URLEncodedUtils.format(nvps, charset);
            }

            // Get请求
            httpGet = new HttpGet(url); // HttpUriRequest httpGet

            // 设置header
            if (headerMap != null) {
                for (Map.Entry<String, String> entry : headerMap.entrySet()) {
                    httpGet.addHeader(entry.getKey(), entry.getValue());
                }
            }

            // 发送请求，返回响应
            response = httpclient.execute(httpGet);

            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                HttpEntity entity = response.getEntity();
//				BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent(), charset));
//                String line;
//                while ((line = reader.readLine()) != null) {
//                    if (pretty)
//                    	contentSb.append(line).append(System.getProperty("line.separator"));
//                    else
//                    	contentSb.append(line);
//                }
//				reader.close();
                responseContent = EntityUtils.toString(entity, charset);
            }
            // EntityUtils.consume(entity);
        } catch (ClientProtocolException e) {
            log.error(e.getMessage(), e);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        } catch (ParseException e) {
            log.error(e.getMessage(), e);
        } finally {
            try {
                if(response!=null){
                    response.close();
                }
                if(httpGet!=null){
                    httpGet.releaseConnection();
                }
                if(httpclient!=null){
                    httpclient.close();
                }
            } catch (IOException e) {
                log.error(e.getMessage(), e);
            }
        }
        return responseContent;
    }

    /**
     * 执行一个http/https post请求，返回请求响应的文本数据
     *
     * @param url		请求的URL地址，可以带参数?param1=a&parma2=b
     * @param headerMap	请求头参数map，可以为null
     * @param paramMap	请求参数map，可以为null
     * @param charset	字符集
     * @param pretty	是否美化
     * @return 			返回请求响应的文本数据
     */
    public static String doPost(String url, Map<String, String> headerMap, Map<String, String> paramMap, String charset, boolean pretty) {
        //StringBuffer contentSb = new StringBuffer();
        String responseContent = "";
        // http客户端
        CloseableHttpClient httpclient = null;
        // Post请求
        HttpPost httpPost = null;
        // http响应
        CloseableHttpResponse response = null;
        try {

            if(url.startsWith("https")){
                httpclient = HttpsSSLClient.createSSLInsecureClient();
            } else {
                httpclient = HttpClients.createDefault();
            }

            // Post请求
            httpPost = new HttpPost(url);

            // 设置header
            if (headerMap != null) {
                for (Map.Entry<String, String> entry : headerMap.entrySet()) {
                    httpPost.addHeader(entry.getKey(), entry.getValue());
                }
            }

            // 设置参数
            if (paramMap != null) {
                List <NameValuePair> nvps = new ArrayList <NameValuePair>();
                for (Map.Entry<String, String> entry : paramMap.entrySet()) {
                    nvps.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
                }
                httpPost.setEntity(new UrlEncodedFormEntity(nvps, charset));
            }

            // 发送请求，返回响应
            response = httpclient.execute(httpPost);
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                HttpEntity entity = response.getEntity();
//				BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent(), charset));
//                String line;
//                while ((line = reader.readLine()) != null) {
//                    if (pretty)
//                    	contentSb.append(line).append(System.getProperty("line.separator"));
//                    else
//                    	contentSb.append(line);
//                }
//				reader.close();
                responseContent = EntityUtils.toString(entity, charset);
            }
            // EntityUtils.consume(entity);
        } catch (UnsupportedEncodingException e) {
            log.error(e.getMessage(), e);
        } catch (ClientProtocolException e) {
            log.error(e.getMessage(), e);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        } catch (ParseException e) {
            log.error(e.getMessage(), e);
        } finally {
            try {
                if(response!=null){
                    response.close();
                }
                if(httpPost!=null){
                    httpPost.releaseConnection();
                }
                if(httpclient!=null){
                    httpclient.close();
                }
            } catch (IOException e) {
                log.error(e.getMessage(), e);
            }
        }
        return responseContent;
    }

    /**
     * 执行一个http/https post请求， 直接写数据 json,xml,txt
     *
     * @param url		请求的URL地址
     * @param headerMap	请求头参数map，可以为null
     * @param content	json或xml等字符串内容
     * @param charset	字符集
     * @param pretty	是否美化
     * @return			返回请求响应的文本数据
     */
    public static String writePost(String url, Map<String, String> headerMap, String content, String charset, boolean pretty) {
        //StringBuffer contentSb = new StringBuffer();
        String responseContent = "";
        // http客户端
        CloseableHttpClient httpclient = null;
        // Post请求
        HttpPost httpPost = null;
        // http响应
        CloseableHttpResponse response = null;
        try {

            if(url.startsWith("https")){
                httpclient = HttpsSSLClient.createSSLInsecureClient();
            } else {
                httpclient = HttpClients.createDefault();
            }

            // Post请求
            httpPost = new HttpPost(url);

            // 设置header
            if (headerMap != null) {
                for (Map.Entry<String, String> entry : headerMap.entrySet()) {
                    httpPost.addHeader(entry.getKey(), entry.getValue());
                }
            }

            // 字符串Entity
            StringEntity stringEntity = new StringEntity(content, charset);
            stringEntity.setContentType("text/plain"); //application/json,text/xml,text/plain
            httpPost.setEntity(stringEntity);

            // 发送请求，返回响应
            response = httpclient.execute(httpPost);
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                HttpEntity entity = response.getEntity();
//				BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent(), charset));
//                String line;
//                while ((line = reader.readLine()) != null) {
//                    if (pretty)
//                    	contentSb.append(line).append(System.getProperty("line.separator"));
//                    else
//                    	contentSb.append(line);
//                }
//				reader.close();
                responseContent = EntityUtils.toString(entity, charset);
            }
            // EntityUtils.consume(entity);
        } catch (UnsupportedEncodingException e) {
            log.error(e.getMessage(), e);
        } catch (ClientProtocolException e) {
            log.error(e.getMessage(), e);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        } catch (ParseException e) {
            log.error(e.getMessage(), e);
        } finally {
            try {
                if(response!=null){
                    response.close();
                }
                if(httpPost!=null){
                    httpPost.releaseConnection();
                }
                if(httpclient!=null){
                    httpclient.close();
                }
            } catch (IOException e) {
                log.error(e.getMessage(), e);
            }
        }
        return responseContent;

    }

    // 通过code获取openId
    public static String getOpenId(String code) {
        if (StringUtils.isNotEmpty(code)) {
            String appid = EnvUtils.getProperty("wx.appid");
            String secret = EnvUtils.getProperty("wx.appsecret");
            String result = HttpUtil.doGet("https://api.weixin.qq.com/sns/oauth2/access_token?appid=" + appid + "&secret=" + secret + "&code=" + code + "&grant_type=authorization_code", null, null, "UTF-8",true);
            if (StringUtils.isNotEmpty(result)) {
                JSONObject json = JSONObject.fromObject(result);
                if (json.get("openid") != null) {
                    return json.get("openid").toString();
                }
            }
        }
        return "";
    }

    public static void main(String[] args) {
        try {
            String y = doGet("http://video.sina.com.cn/life/tips.html", null, null, "GBK", true);
            System.out.println(y);
//        		String accessToken = HttpUtil.doGet("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=appid&secret=secret", null, null, "UTF-8", true);
//        		System.out.println(accessToken);
//              Map params = new HashMap();
//              params.put("param1", "value1");
//              params.put("json", "{\"aa\":\"11\"}");
//              String j = doPost("http://localhost/uplat/manage/test.do?reqCode=add", null, params, "UTF-8", true);
//              System.out.println(j);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
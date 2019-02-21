package com.sunland.interceptor;

import com.sunland.exception.AuthorizationException;
import com.sunland.exception.BadRequestException;
import com.sunland.pojo.Account;
import com.sunland.service.AccountService;
import com.sunland.utils.AES128;
import com.sunland.utils.StringUtil;
import joptsimple.internal.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by batwings on 16/01/06.
 */
public class SessionInterceptor implements HandlerInterceptor {

    @Autowired
    private AccountService accountService;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        String path = httpServletRequest.getServletPath();
        if(path.startsWith("/api/common")){
            return true;
        }
        String device = httpServletRequest.getParameter("deviceId");
        String token = httpServletRequest.getParameter("token");
        if(Strings.isNullOrEmpty(token)){
            throw new BadRequestException("none token");
        }
        Cookie[] cookies = httpServletRequest.getCookies();
        Cookie cookie = null;
        Account accounttemp = null;
        String sid = "";
        if(cookies != null){
            for(int i=0;i<cookies.length;i++){
                cookie = cookies[i];
                if("tokenid".equals(cookie.getName()) && StringUtil.MD5(token).equals(cookie.getValue())){
                    if("IOS".equals(device) || "Android".equals(device)){
                        accounttemp = accountService.selectAccountByToken(token,0);
                        if(accounttemp == null){
                            throw new AuthorizationException("账号不存在");
                        }
                        Calendar calendar = Calendar.getInstance();
                        if(accounttemp.getSessiontime() == null){
                            //过期
                            throw new AuthorizationException("登入已超时");
                        }
                        calendar.setTime(accounttemp.getSessiontime());
                        calendar.add(Calendar.DAY_OF_MONTH,3);
                        if(calendar.getTime().compareTo(new Date()) < 0){
                            //过期
                            throw new AuthorizationException("登入已超时");
                        }
                    }else if("WX".equals(device)){
                        accounttemp = accountService.selectAccountByToken(token,1);
                    }else {
                        throw new BadRequestException("not found device");
                    }
                }
                if("sid".equals(cookie.getName())){
                    sid = cookie.getValue();
                }
            }
            if(accounttemp!=null && AES128.encrypt1(String.valueOf(accounttemp.getAccountid())).equals(sid)){
                httpServletRequest.getSession().setAttribute("accountId",accounttemp.getAccountid());
                return true;
            }
        }


        Account account;
        if("IOS".equals(device) || "Android".equals(device)){
            account = accountService.selectAccountByToken(token,0);
            if(account == null){
                throw new AuthorizationException("账号不存在");
            }
            Calendar calendar = Calendar.getInstance();
            if(account.getSessiontime() == null){
                //过期
                throw new AuthorizationException("登入已超时");
            }
            calendar.setTime(account.getSessiontime());
            calendar.add(Calendar.DAY_OF_MONTH,3);
            if(calendar.getTime().compareTo(new Date()) < 0){
                //过期
                throw new AuthorizationException("登入已超时");
            }
            token = StringUtil.MD5(token);
        }else if("WX".equals(device)){
            account = accountService.selectAccountByToken(token,1);
            if(account == null){
                throw new AuthorizationException("账号不存在");
            }
        }else {
            throw new BadRequestException("not found device");
        }
        Integer id = account.getAccountid();
        Cookie cookieSid = new Cookie("sid", AES128.encrypt1(String.valueOf(id)));
        httpServletRequest.getSession().setAttribute("accountId",id);
        Cookie tokenid = new Cookie("tokenid",token);
        cookieSid.setMaxAge(60*60*6);
        tokenid.setMaxAge(60*60*6);
        httpServletResponse.addCookie(cookieSid);
        httpServletResponse.addCookie(tokenid);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

        System.out.println("SessionInterceptor ---> postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

        System.out.println("SessionInterceptor ---> afterCompletion");
    }
}

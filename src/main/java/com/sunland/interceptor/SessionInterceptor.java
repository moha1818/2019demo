package com.sunland.interceptor;

import com.sunland.exception.AuthorizationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by batwings on 16/01/06.
 */
public class SessionInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        System.out.println(httpServletRequest.getRequestURL().toString());
        if("111111a".equals(httpServletRequest.getHeader("access-token")))
            return true;

        httpServletResponse.setStatus(HttpServletResponse.SC_FORBIDDEN);
        return false;

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

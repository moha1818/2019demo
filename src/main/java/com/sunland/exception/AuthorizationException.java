package com.sunland.exception;

/**
 * Created by batwings on 16/01/06.
 */

/**
 * 用于拦截器拦截未登录页面访问
 */
public class AuthorizationException extends Exception {
    private static final long serialVersionUID = 726227859865480176L;
    public AuthorizationException(String msg) {
        super(msg);
    }

    public AuthorizationException() {
    }

    public AuthorizationException(Throwable cause) {
        super(cause);
    }

    public AuthorizationException(String message, Throwable cause) {
        super(message, cause);
    }
}

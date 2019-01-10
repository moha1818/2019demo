package com.sunland.exception;

/**
 * Socket访问异常
 *
 * @author lq
 * @create on 2016-08-01
 */
public class SocketAccessException extends Exception {

    private Throwable exception = null;
    private String message;

    public SocketAccessException() {
        this.message = "SocketError";
    }

    public SocketAccessException(String message) {
        this.message = message;
    }

    public SocketAccessException(Throwable e) {
        this.exception = e;
    }

    public Throwable getException() {
        return exception;
    }

    public String getMessage() {
        return message;
    }
}
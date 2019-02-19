package com.sunland.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


public class BizException extends RuntimeException {
    private static final long serialVersionUID = -4617646556752418103L;

    public BizException(String msg) {
        super(msg);
    }

    public BizException() {
    }
}

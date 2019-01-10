package com.sunland.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus (value = HttpStatus.BAD_REQUEST, code = HttpStatus.BAD_REQUEST)
public class ValidateException extends RuntimeException {

    /**
     * Instantiates a new Validate exception.
     * @param message the message
     */
    public ValidateException(String message) {
        super(message);
    }
}

package com.sunland.exception;

/**
 * Created by lq on 16/07/11.
 */
public class ReadFileException extends RuntimeException {
    public ReadFileException() {
    }

    public ReadFileException(String message) {
        super(message);
    }
}

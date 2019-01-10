package com.sunland.exception;

public class PermissionException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public PermissionException(String message) {
        super(message);
    }

    public PermissionException() {
    }
}

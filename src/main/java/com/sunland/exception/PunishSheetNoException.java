package com.sunland.exception;

/**
 * 定义一个获取处罚决定书异常类
 */
public class PunishSheetNoException extends RuntimeException {

    public PunishSheetNoException() {
    }

    public PunishSheetNoException(String message) {
        super(message);
    }
}

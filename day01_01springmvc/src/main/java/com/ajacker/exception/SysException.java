package com.ajacker.exception;

/**
 * @author ajacker
 * @date 2019/10/18 13:40
 */
public class SysException extends Exception {
    private String message;

    public SysException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

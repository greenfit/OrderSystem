package com.heleeos.demo.order.exception;

/**
 * Created by liyu on 2018/11/14.
 */
public class WebException extends Exception {

    private int code;

    private String message;

    public WebException() {}

    public WebException(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

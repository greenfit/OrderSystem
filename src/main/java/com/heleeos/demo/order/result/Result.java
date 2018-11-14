package com.heleeos.demo.order.result;

import com.google.gson.Gson;

/**
 * Created by liyu on 2018/11/14.
 */
public class Result<T> {

    private int code;

    private String message;

    private T data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}

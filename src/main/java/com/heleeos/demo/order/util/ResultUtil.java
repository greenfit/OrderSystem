package com.heleeos.demo.order.util;

import com.heleeos.demo.order.exception.WebException;
import com.heleeos.demo.order.result.Result;

/**
 * Created by liyu on 2018/11/14.
 */
public class ResultUtil {

    public static <T> Result<T> build(int code, String message, T data) {
        Result<T> result = new Result<>();
        result.setCode(code);
        result.setMessage(message);
        result.setData(data);
        return result;
    }

    public static <T> Result<T> success(T data) {
        return build(200, "请求成功", data);
    }

    public static <T> Result<T> error(WebException exception) {
        return build(exception.getCode(), exception.getMessage(), null);
    }
}

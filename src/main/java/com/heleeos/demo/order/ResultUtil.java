package com.heleeos.demo.order;

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
}

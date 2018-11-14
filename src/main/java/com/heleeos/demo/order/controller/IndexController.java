package com.heleeos.demo.order.controller;

import com.heleeos.demo.order.ResultUtil;
import com.heleeos.demo.order.result.Result;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Created by liyu on 2018/11/11.
 */
@RestController
@RequestMapping("/")
public class IndexController {

    @RequestMapping("/")
    public String getData() {
        return UUID.randomUUID().toString();
    }

    @RequestMapping("time.json")
    public String time() {
        return LocalDateTime.now().toString();
    }

    @RequestMapping("login.json")
    public Result<Integer> login(@RequestBody String userName) {
        return ResultUtil.build(200, userName + ", 登录成功", 0);
    }
}

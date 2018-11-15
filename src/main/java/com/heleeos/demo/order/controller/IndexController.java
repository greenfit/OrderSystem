package com.heleeos.demo.order.controller;

import com.heleeos.demo.order.bean.User;
import com.heleeos.demo.order.exception.WebException;
import com.heleeos.demo.order.util.ResultUtil;
import com.heleeos.demo.order.result.Result;
import com.heleeos.demo.order.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Created by liyu on 2018/11/11.
 */
@RestController
@RequestMapping("/")
public class IndexController {

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String getData() {
        return UUID.randomUUID().toString();
    }

    @RequestMapping("time.json")
    public String time() {
        return LocalDateTime.now().toString();
    }

    @RequestMapping("login.json")
    public Result<Boolean> login(@RequestBody String userName, HttpServletResponse httpServletResponse) {
        try {
            User user = userService.addUser(userName);
            addCookie(httpServletResponse, user.getId());
            return ResultUtil.success(true);
        } catch (WebException e) {
            return ResultUtil.error(e);
        }
    }

    private void addCookie(HttpServletResponse response, int userId){
        Cookie cookie = new Cookie("userId",userId + "");
        cookie.setMaxAge(24 * 60 * 60);
        cookie.setPath("/");
        response.addCookie(cookie);
    }
}

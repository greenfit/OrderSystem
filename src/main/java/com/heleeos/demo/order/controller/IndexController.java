package com.heleeos.demo.order.controller;

import com.heleeos.demo.order.bean.Order;
import com.heleeos.demo.order.bean.User;
import com.heleeos.demo.order.exception.WebException;
import com.heleeos.demo.order.services.OrderService;
import com.heleeos.demo.order.util.ResultUtil;
import com.heleeos.demo.order.result.Result;
import com.heleeos.demo.order.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * Created by liyu on 2018/11/11.
 */
@RestController
@RequestMapping("/")
public class IndexController {

    @Autowired
    private UserService userService;

    @Autowired
    private OrderService orderService;

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
            User user = userService.getUser(userName);
            if(user == null) {
                user = userService.addUser(userName);
            }
            addCookie(httpServletResponse, user.getId());
            return ResultUtil.success(true);
        } catch (WebException e) {
            return ResultUtil.error(e);
        }
    }

    @RequestMapping("payOrder")
    public Result<Boolean> payOrder(@RequestBody Order order) {
        try {
            orderService.addOrder(order);
            return ResultUtil.success(true);
        } catch (WebException e) {
            return ResultUtil.error(e);
        }
    }

    @RequestMapping("getOrder.json")
    public Result<List<Order>> getOrder(@RequestParam int userId) {
        return ResultUtil.success(orderService.getOrderList(userId));
    }

    private void addCookie(HttpServletResponse response, int userId){
        Cookie cookie = new Cookie("userId",userId + "");
        cookie.setMaxAge(24 * 60 * 60);
        cookie.setPath("/");
        response.addCookie(cookie);
    }
}

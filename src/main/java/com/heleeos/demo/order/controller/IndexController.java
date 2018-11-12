package com.heleeos.demo.order.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;

/**
 * Created by liyu on 2018/11/11.
 */
@RestController
@RequestMapping("/")
public class IndexController {

    @RequestMapping("/")
    public ModelAndView index() {
        return new ModelAndView("index");
    }

    @RequestMapping("login")
    public ModelAndView login() {
        return new ModelAndView("login");
    }

    @RequestMapping("time")
    public String time() {
        return LocalDateTime.now().toString();
    }
}

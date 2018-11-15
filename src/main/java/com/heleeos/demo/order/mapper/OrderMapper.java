package com.heleeos.demo.order.mapper;

import com.heleeos.demo.order.bean.Order;

import java.util.List;

public interface OrderMapper {

    int insert(Order order);

    List<Order> getListByUserId(Integer userId);
}
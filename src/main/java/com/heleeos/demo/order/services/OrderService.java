package com.heleeos.demo.order.services;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.heleeos.demo.order.bean.Item;
import com.heleeos.demo.order.bean.Order;
import com.heleeos.demo.order.bean.User;
import com.heleeos.demo.order.exception.WebException;
import com.heleeos.demo.order.mapper.OrderMapper;
import com.heleeos.demo.order.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by liyu on 2018/11/14.
 */
@Service
public class OrderService {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderService.class);

    @Autowired
    private OrderMapper orderMapper;

    public Order addOrder(Order order) throws WebException {
        try {
            String orderStr = String.format("1%d%04d%04d", System.currentTimeMillis() / 1000, order.getUserId(), (int)(Math.random() * 10000));
            order.setOrder(orderStr);
            order.setItems(new String(Base64.getEncoder().encode(order.getItems().getBytes())));
            int result = orderMapper.insert(order);
            if(result > 0) {
                return order;
            }
            throw new WebException(500, "保存订单信息失败");
        } catch (Exception e) {
            LOGGER.error("保存订单信息失败", e);
            throw new WebException(400, "保存订单信息失败");
        }
    }

    public List<Order> getOrderList(Integer userId) {
        return orderMapper.getListByUserId(userId).stream().map(order -> {
            String str = new String(Base64.getDecoder().decode(order.getItems().getBytes()));
            List<Item> itemList = new Gson().fromJson(str, new TypeToken<List<Item>>() {}.getType());
            order.setItemList(itemList);

            Date date = order.getCreateTime();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            order.setTimeStr(dateFormat.format(date));

            return order;
        }).collect(Collectors.toList());
    }
}

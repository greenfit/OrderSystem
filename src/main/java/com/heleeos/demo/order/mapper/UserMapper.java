package com.heleeos.demo.order.mapper;

import com.heleeos.demo.order.bean.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {

    User getUser(@Param("name") String name);

    int insert(User user);
}
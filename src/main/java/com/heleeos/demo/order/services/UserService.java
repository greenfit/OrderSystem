package com.heleeos.demo.order.services;

import com.heleeos.demo.order.bean.User;
import com.heleeos.demo.order.exception.WebException;
import com.heleeos.demo.order.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by liyu on 2018/11/14.
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User addUser(String userName) throws WebException {
        User user = new User();
        user.setName(userName);

        try {
            int result = userMapper.insert(user);
            if(result > 0) {
                return user;
            }
            throw new WebException(500, "保存用户信息失败");
        } catch (Exception e) {
            throw new WebException(400, "用户名已存在");
        }
    }
}

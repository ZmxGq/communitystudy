package com.zmx.communitystudy.service;

import com.zmx.communitystudy.dao.UserMapper;
import com.zmx.communitystudy.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zmx
 * @create 2022-06-20 21:01
 */
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public User selectUserById(Integer id){
        return userMapper.selectUserById(id);
    }
}

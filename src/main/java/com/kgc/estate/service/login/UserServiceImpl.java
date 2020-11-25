package com.kgc.estate.service.login;


import com.kgc.estate.dao.UserMapper;
import com.kgc.estate.pojo.User;
import com.kgc.estate.pojo.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;


    public List<User> getUser(User user) {
        UserExample userExample=new UserExample();
        userExample.createCriteria().andCardidEqualTo(user.getCardid()).andPasswordEqualTo(user.getPassword());
        List<User> users = userMapper.selectByExample(userExample);
        return users;
    }
}

package com.kgc.estate.service.addUser.impl;

import com.kgc.estate.dao.UserMapper;
import com.kgc.estate.pojo.User;
import com.kgc.estate.pojo.UserExample;
import com.kgc.estate.service.addUser.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    UserMapper userMapper;

    public int addUser(User user) {
        return userMapper.insertSelective(user);
    }

    public int selectID(String cardid) {
        UserExample example=new UserExample();
        example.createCriteria().andCardidEqualTo(cardid);
        return userMapper.countByExample(example);
    }

}

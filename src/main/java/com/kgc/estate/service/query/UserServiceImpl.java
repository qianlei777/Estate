package com.kgc.estate.service.query;

import com.kgc.estate.dao.UserMapper;
import com.kgc.estate.pojo.User;
import com.kgc.estate.pojo.UserExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    UserMapper userMapper;

    public String getUserCardIdByUserName(String name) {
        UserExample example = new UserExample();
        example.createCriteria().andNameEqualTo(name);
        List<User> users = userMapper.selectByExample(example);
        if (users.size() > 0) {
            return users.get(0).getCardid();
        }
        return null;
    }
}

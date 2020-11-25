package com.kgc.estate.service.login;

import com.kgc.estate.pojo.User;

import java.util.List;

public interface UserService {
    //用户登录方法
    List<User> getUser(User user);
}

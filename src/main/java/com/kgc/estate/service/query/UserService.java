package com.kgc.estate.service.query;

import com.kgc.estate.pojo.User;

public interface UserService {
    //根据用户名查找身份证
    String getUserCardIdByUserName(String name);
}

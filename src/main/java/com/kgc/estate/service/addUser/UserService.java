package com.kgc.estate.service.addUser;

import com.kgc.estate.pojo.User;

public interface UserService {
    int addUser(User user);
    int selectID(String cardid);
}

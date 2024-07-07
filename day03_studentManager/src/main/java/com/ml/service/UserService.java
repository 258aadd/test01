package com.ml.service;

import com.ml.pojo.User;

public interface UserService {
    User login(String username, String password);
    User getUserByName(String username);
}

package com.product.org.service;

import com.product.org.model.User;

import java.util.Map;

public interface UserService {

    boolean registerUser(User user);

    Map<String, Object> userAuthentication(String userName, String password);
}

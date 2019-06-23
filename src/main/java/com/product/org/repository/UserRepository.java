package com.product.org.repository;

import com.product.org.model.User;

import java.util.List;

public interface UserRepository {
    User addUser(User user);
    List<User> getAllUsers();
    User userAuthentication(String userName,String passWord);
    boolean doUserNameExist(String userName);
    boolean doEmailExist(String email);
 }

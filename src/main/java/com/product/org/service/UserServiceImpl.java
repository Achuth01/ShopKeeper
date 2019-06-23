package com.product.org.service;

import com.product.org.model.JwtUser;
import com.product.org.model.User;
import com.product.org.repository.UserRepository;
import com.product.org.security.JwtGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;



    @Override
    public boolean registerUser(User user) {
        if(userRepository.doUserNameExist(user.getUserName()))
            throw new RuntimeException("user name already exists");
        if(userRepository.doEmailExist(user.getEmail()))
            throw new RuntimeException("email already exists");
        try{
            userRepository.addUser(user);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public Map<String, Object> userAuthentication(String userName, String password) {

        User user = userRepository.userAuthentication(userName,password);

        if(user == null)
            throw new RuntimeException("Incorrect UserName/Password");

        JwtUser jwtUser = new JwtUser();
        jwtUser.setRole("OPERATIONS");
        jwtUser.setUserName(user.getUserName());
        jwtUser.setUserId(user.getId());

        JwtGenerator generator = new JwtGenerator();
        HashMap<String, Object> map = new HashMap<>();
        map.put("token", generator.generate(jwtUser));
        return map;
    }
}

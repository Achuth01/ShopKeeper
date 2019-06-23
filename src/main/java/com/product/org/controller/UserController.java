package com.product.org.controller;

import com.product.org.model.User;
import com.product.org.service.UserService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/user/register")
    public boolean registerUser(@RequestBody User user){
        return userService.registerUser(user);
    }

    @PostMapping(value = "/user/login")
    public Map<String,Object> userAuthentication(@RequestParam String userName,@RequestParam String password) {
        return userService.userAuthentication(userName,password);
    }

}

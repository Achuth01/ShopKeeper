package com.product.org.controller;

import com.product.org.model.JwtUser;
import com.product.org.security.JwtGenerator;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class JwtController {

    @PostMapping("/token")
    public String generateToken(@RequestBody JwtUser user){
        JwtGenerator jwtGenerator=new JwtGenerator();
        return jwtGenerator.generate(user);
    }
}

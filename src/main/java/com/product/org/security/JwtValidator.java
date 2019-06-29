package com.product.org.security;

import com.product.org.model.JwtUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

public class JwtValidator {


    public static JwtUser validate(String token) {
        JwtUser jwtuser = new JwtUser();
        try {
            String signingKey = "achuth";
            Claims body = Jwts.parser().setSigningKey(signingKey).parseClaimsJws(token).getBody();
            jwtuser.setUserName(body.getSubject());
            jwtuser.setUserId((String) body.get("id"));
            jwtuser.setRole((String) body.get("role"));
        }catch (Exception e){
            throw new RuntimeException("JWT token is not valid");
        }
        return jwtuser;
    }

}

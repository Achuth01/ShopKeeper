package com.product.org.security;

import com.product.org.model.JwtUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class JwtGenerator {

     public String generate(JwtUser jwtUser){
         Claims claims = Jwts.claims().setSubject(jwtUser.getUserName());
         claims.put("id",jwtUser.getUserId());
         claims.put("role",jwtUser.getRole());
         return Jwts.builder().setClaims(claims).setExpiration(new Date(System.currentTimeMillis()+ TimeUnit.MINUTES.toMillis(10))).signWith(SignatureAlgorithm.HS512,"achuth").compact();
     }
}

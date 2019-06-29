package com.product.org.model;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class JwtAuthenticationToken extends UsernamePasswordAuthenticationToken {

    private static String token;

    public JwtAuthenticationToken(String token) {
        super(null,null);
        this.token = token;
    }

    public static String getToken() {
        return token;
    }


    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return null;
    }
}

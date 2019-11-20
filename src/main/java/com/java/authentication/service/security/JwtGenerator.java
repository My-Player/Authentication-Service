package com.java.authentication.service.security;

import com.java.authentication.service.dto.UserLogin;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

@Component
public class JwtGenerator {


    public String generate(UserLogin userLogin)
    {
        Claims claims = Jwts.claims().setSubject(userLogin.getEmail());
        claims.put("email",userLogin.getEmail());
        claims.put("password",userLogin.getPassword());

        return Jwts.builder().setClaims(claims).signWith(SignatureAlgorithm.HS384,"google").compact();

    }
}

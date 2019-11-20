package com.java.authentication.service.security;

import com.java.authentication.service.dto.UserLoginDTO;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

@Component
public class JwtGenerator {


    public String generate(UserLoginDTO userLoginDTO)
    {
        Claims claims = Jwts.claims().setSubject(userLoginDTO.getEmail());
        claims.put("email", userLoginDTO.getEmail());
        claims.put("password", userLoginDTO.getPassword());

        return Jwts.builder().setClaims(claims).signWith(SignatureAlgorithm.HS384,"google").compact();

    }
}

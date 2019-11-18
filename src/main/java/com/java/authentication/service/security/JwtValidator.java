package com.java.authentication.service.security;

import com.java.authentication.service.dto.UserLogin;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class JwtValidator {
    private String secret = "google";
    public static final Logger log = LogManager.getLogger(JwtValidator.class.getName());

    public UserLogin validate(String token){
        UserLogin userLogin = null;

        try{
            Claims body = Jwts.parser().setSigningKey(secret)
                    .parseClaimsJws(token).getBody();

            userLogin = new UserLogin();
            userLogin.setEmail(body.getSubject());
            userLogin.setPassword(body.getSubject());

        }catch(Exception e){
            log.info(e.getMessage());
        }
        return  userLogin;
    }
}

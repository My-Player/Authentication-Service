package com.java.authentication.service.security;

import com.java.authentication.service.dto.UserLoginDTO;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class JwtValidator {
    private String secret = "google";
    public static final Logger log = LogManager.getLogger(JwtValidator.class.getName());

    public UserLoginDTO validate(String token){
        UserLoginDTO userLoginDTO = null;

        try{
            Claims body = Jwts.parser().setSigningKey(secret)
                    .parseClaimsJws(token).getBody();

            userLoginDTO = new UserLoginDTO();
            userLoginDTO.setEmail(body.getSubject());
            userLoginDTO.setPassword(body.getSubject());

        }catch(Exception e){
            log.info(e.getMessage());
        }
        return userLoginDTO;
    }
}

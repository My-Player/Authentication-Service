package com.java.authentication.service.security;

import com.java.authentication.service.domain.UserData;
import com.java.authentication.service.dto.JwtUserDetails;
import com.java.authentication.service.dto.UserLoginDTO;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class JwtAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider
{
    private JwtValidator validator;

    public JwtAuthenticationProvider(JwtValidator validator) {
        this.validator = validator;
    }

    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) throws AuthenticationException {

    }

    @Override
    protected UserDetails retrieveUser(String s, UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) throws AuthenticationException {
        JwtAuthenticationToken jwtToken = (JwtAuthenticationToken) usernamePasswordAuthenticationToken;
        String token = jwtToken.getToken();

        UserLoginDTO userLoginDTO = validator.validate(token);
        if(userLoginDTO == null){throw new RuntimeException("Incorrect JWT Token");}

        UserData userData = new UserData();
        userData.setUserEmail(userLoginDTO.getEmail());
        userData.setPassword(userLoginDTO.getPassword());

        return new JwtUserDetails(userData);
    }
    @Override
    public boolean supports(Class<?> aClass) {
        return (JwtAuthenticationToken.class.isAssignableFrom(aClass));
    }
}

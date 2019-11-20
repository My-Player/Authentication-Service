package com.java.authentication.service.service.impl;

import com.java.authentication.service.dao.UserRepository;
import com.java.authentication.service.domain.UserData;
import com.java.authentication.service.dto.ErrorResponse;
import com.java.authentication.service.dto.LoginResponse;
import com.java.authentication.service.dto.UserLogin;
import com.java.authentication.service.security.JwtAuthenticationToken;
import com.java.authentication.service.security.JwtGenerator;
import com.java.authentication.service.service.LoginService;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import static com.java.authentication.service.constant.StatusConstant.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    UserDetailService userDetailService;

    @Autowired
    UserRepository userRepository;

    PasswordEncoder passwordEncoder;

    JwtGenerator jwtGenerator;

    @Autowired
    public LoginServiceImpl(PasswordEncoder passwordEncoder, JwtGenerator jwtGenerator) {
        this.passwordEncoder = passwordEncoder;
        this.jwtGenerator = jwtGenerator;
    }

    @Override
    public LoginResponse loginUser(UserLogin userLogin, HttpServletResponse response) throws IOException {
        userDetailService.loadUserByUsername(userLogin.getEmail());
        UserData userData = userRepository.findUserByUserEmail(userLogin.getEmail());
        String password = userLogin.getPassword();

        if(!passwordEncoder.matches(password, userData.getPassword())) {
            return new LoginResponse(500,FAILED.getMessage(),"");
        }

        userLogin.setEmail(userData.getUserEmail());
        JwtAuthenticationToken token = new JwtAuthenticationToken(jwtGenerator.generate(userLogin));
        token.setToken(jwtGenerator.generate(userLogin));

        String payload = token.getToken().split("\\.")[1];
        return new LoginResponse(200,SUCCESS.getMessage(),payload);
    }
}

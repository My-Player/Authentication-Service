package com.java.authentication.service.service.impl;

import com.java.authentication.service.dao.UserRepository;
import com.java.authentication.service.domain.UserData;
import com.java.authentication.service.dto.ErrorResponse;
import com.java.authentication.service.dto.LoginResponse;
import com.java.authentication.service.dto.UserLoginDTO;
import com.java.authentication.service.security.JwtAuthenticationToken;
import com.java.authentication.service.security.JwtGenerator;
import com.java.authentication.service.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import static com.java.authentication.service.constant.StatusConstant.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Service
public class LoginServiceImpl implements LoginService {

    final UserDetailService userDetailService;

    final UserRepository userRepository;

    PasswordEncoder passwordEncoder;

    JwtGenerator jwtGenerator;

    @Autowired
    public LoginServiceImpl(PasswordEncoder passwordEncoder, JwtGenerator jwtGenerator, UserRepository userRepository, UserDetailService userDetailService) {
        this.passwordEncoder = passwordEncoder;
        this.jwtGenerator = jwtGenerator;
        this.userRepository = userRepository;
        this.userDetailService = userDetailService;
    }

    @Override
    public LoginResponse loginUser(UserLoginDTO userLoginDTO, HttpServletResponse response) throws IOException {
        userDetailService.loadUserByUsername(userLoginDTO.getEmail());
        UserData userData = userRepository.findUserByUserEmail(userLoginDTO.getEmail());
        String password = userLoginDTO.getPassword();

        if(!passwordEncoder.matches(password, userData.getPassword())) {
           ErrorResponse errorResponse = new ErrorResponse("Incorrect Password!");
            response.sendError(401,errorResponse.getMessage());
            return new LoginResponse(response.getStatus(),errorResponse.getMessage(),"");
        }

        userLoginDTO.setEmail(userData.getUserEmail());
        JwtAuthenticationToken token = new JwtAuthenticationToken(jwtGenerator.generate(userLoginDTO));
        token.setToken(jwtGenerator.generate(userLoginDTO));

        String payload = token.getToken().split("\\.")[1];
        return new LoginResponse(200,SUCCESS.getMessage(),payload);
    }
}

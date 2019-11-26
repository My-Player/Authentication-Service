package com.java.authentication.service.service.impl;

import com.java.authentication.service.dao.UserRepository;
import com.java.authentication.service.domain.UserData;
import com.java.authentication.service.dto.LoginResponse;
import com.java.authentication.service.dto.MessageResponse;
import com.java.authentication.service.dto.UserLoginDTO;
import com.java.authentication.service.security.JwtAuthenticationToken;
import com.java.authentication.service.security.JwtGenerator;
import com.java.authentication.service.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.java.authentication.service.constant.StatusConstant.SUCCESS;

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
        UserDetails detailService = userDetailService.loadUserByUsername(userLoginDTO.getEmail());
        UserData userData = userRepository.findUserByUserEmail(userLoginDTO.getEmail());
        String password = userLoginDTO.getPassword();

        if(detailService == null){
            MessageResponse errorMessageResponse = new MessageResponse("Incorrect Username!");
            response.sendError(401, errorMessageResponse.getMessage());
            return new LoginResponse(response.getStatus(), errorMessageResponse.getMessage(),"");
        }

        if(!passwordEncoder.matches(password, userData.getPassword())) {
           MessageResponse errorMessageResponse = new MessageResponse("Incorrect Password!");
            response.sendError(401, errorMessageResponse.getMessage());
            return new LoginResponse(response.getStatus(), errorMessageResponse.getMessage(),"");
        }

        userLoginDTO.setEmail(userData.getUserEmail());
        JwtAuthenticationToken token = new JwtAuthenticationToken(jwtGenerator.generate(userLoginDTO));
        token.setToken(jwtGenerator.generate(userLoginDTO));

        String payload = token.getToken().split("\\.")[1];
        return new LoginResponse(200,SUCCESS.getMessage(),payload);
    }
}

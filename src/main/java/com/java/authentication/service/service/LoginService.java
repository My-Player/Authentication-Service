package com.java.authentication.service.service;

import com.java.authentication.service.dto.LoginResponse;
import com.java.authentication.service.dto.UserLoginDTO;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;

@Service
public interface LoginService {
    LoginResponse loginUser(UserLoginDTO userLoginDTO, HttpServletResponse response) throws Exception;

}

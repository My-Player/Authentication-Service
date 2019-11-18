package com.java.authentication.service.service;

import com.java.authentication.service.dto.UserLogin;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Service
public interface LoginService {
    String loginUser(UserLogin userLogin, HttpServletResponse response) throws Exception;
}

package com.java.authentication.service.service;

import com.java.authentication.service.dto.Response;
import com.java.authentication.service.dto.UserRegisterDto;
import org.springframework.stereotype.Service;

@Service
public interface RegisterService {

    Response registerUser(UserRegisterDto userRegisterDto);
}

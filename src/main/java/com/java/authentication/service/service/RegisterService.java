package com.java.authentication.service.service;

import com.java.authentication.service.dto.UserRegisterDto;
import org.springframework.stereotype.Service;

@Service
public interface RegisterService {

    void registerUser(UserRegisterDto userRegisterDto);
}

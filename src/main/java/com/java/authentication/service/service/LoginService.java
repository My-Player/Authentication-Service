package com.java.authentication.service.service;

import com.java.authentication.service.domain.User;
import com.java.authentication.service.dto.UserDTO;
import org.springframework.stereotype.Service;

@Service
public interface LoginService {
    User loginUser(UserDTO userDTO);
}

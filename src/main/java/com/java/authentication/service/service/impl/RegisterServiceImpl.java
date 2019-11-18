package com.java.authentication.service.service.impl;

import com.java.authentication.service.dao.UserRepository;
import com.java.authentication.service.domain.UserData;
import com.java.authentication.service.dto.UserRegisterDto;
import com.java.authentication.service.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterServiceImpl implements RegisterService {

    private final UserRepository userRepository;

    @Autowired
    public RegisterServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }


    @Override
    public void registerUser(UserRegisterDto userRegisterDto) {
      UserData data = new UserData();
      data.setUserEmail(userRegisterDto.getEmail());
      data.setPassword(userRegisterDto.getPassword());
      data.setGender(userRegisterDto.getGender());
      data.setDob(userRegisterDto.getDob());
      data.setUserProvince(userRegisterDto.getProvince());
      data.setUserCity(userRegisterDto.getCity());
      userRepository.save(data);
    }
}

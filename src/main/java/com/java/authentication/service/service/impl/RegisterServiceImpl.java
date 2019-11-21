package com.java.authentication.service.service.impl;

import com.java.authentication.service.dao.UserRepository;
import com.java.authentication.service.domain.UserData;
import com.java.authentication.service.dto.Response;
import com.java.authentication.service.dto.UserRegisterDto;
import com.java.authentication.service.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegisterServiceImpl implements RegisterService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public RegisterServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public Response registerUser(UserRegisterDto userRegisterDto) {
        UserData data = new UserData();
        UserData findUser = userRepository.findUserByUserEmail(userRegisterDto.getEmail());
        if(findUser == null) insertData(data,userRegisterDto);
        if(findUser != null && findUser.getUserEmail().equals(userRegisterDto.getEmail())) return new Response("This Email has Already been Exists!");

        return new Response("success");
    }



    private void insertData(UserData data, UserRegisterDto userRegisterDto){
        data.setUserEmail(userRegisterDto.getEmail());
        data.setPassword(passwordEncoder.encode(userRegisterDto.getPassword()));
        data.setGender(userRegisterDto.getGender());
        data.setDob(userRegisterDto.getDob());
        data.setUserProvince(userRegisterDto.getProvince());
        data.setUserCity(userRegisterDto.getCity());
        userRepository.save(data);
    }
}

package com.java.authentication.service.service.impl;

import com.java.authentication.service.dao.UserRepository;
import com.java.authentication.service.domain.UserData;
import com.java.authentication.service.dto.MessageResponse;
import com.java.authentication.service.dto.UserDataDto;
import com.java.authentication.service.dto.UserDataResponse;
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
    public MessageResponse registerUser(UserDataResponse userDataResponse) {
        UserData data = new UserData();
        UserData findUser = userRepository.findUserByUserEmail(userDataResponse.getData().getEmail());
        if(findUser == null) insertData(data, userDataResponse.getData());
        if(findUser != null && findUser.getUserEmail().equals(userDataResponse.getData().getEmail())) return new MessageResponse("This Email has Already Taken!");



        return new MessageResponse("Success Register Your Data!");
    }



    private void insertData(UserData data, UserDataDto userDataDto){

        data.setUserEmail(userDataDto.getEmail());
        data.setPassword(passwordEncoder.encode(userDataDto.getPassword()));
        data.setGender(userDataDto.getGender());
        data.setDob(userDataDto.getDob());
        data.setUserProvince(userDataDto.getProvince());
        data.setUserCity(userDataDto.getCity());
        data.setUserPhone(userDataDto.getPhone());
        userRepository.save(data);
    }
}

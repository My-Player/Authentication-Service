package com.java.authentication.service.service.impl;

import com.java.authentication.service.dao.UserRepository;
import com.java.authentication.service.domain.UserData;
import com.java.authentication.service.dto.LoginResponse;
import com.java.authentication.service.dto.MessageResponse;
import com.java.authentication.service.dto.UserDTO;
import com.java.authentication.service.dto.UserDataDto;
import com.java.authentication.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RestTemplate restTemplate;


    @Override
    public List<UserData> getUserData() {
        List<UserData> userDataList = userRepository.findAll();
        return userDataList;

    }

    @Override
    public UserDTO getUserDetail(String userId) {
        UserData userData = userRepository.getOne(userId);
        UserDTO response = new UserDTO();
        response.setUserName(userData.getUserEmail());
        response.setUserProvince(userData.getUserProvince());
        response.setUserCity(userData.getUserCity());
        response.setUserAge(calculateUserAge(userData.getDob(),new Date()));

        return response;
    }

    @Override
    public MessageResponse editUserDetail(String userId, UserDataDto userDataDto) {
        UserData userData = userRepository.getOne(userId);
        userData.setUserEmail(userDataDto.getEmail());
        userData.setUserProvince(userDataDto.getProvince());
        userData.setUserCity(userDataDto.getCity());
        userData.setDob(userDataDto.getDob());
        userData.setUserPhone(userDataDto.getPhone());
        userRepository.save(userData);
        return new MessageResponse("Success Updating Your Data!");
    }

    private int calculateUserAge(Date dob, Date currentTime){
        DateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        int mydob = Integer.parseInt(formatter.format(dob));
        int currentDate = Integer.parseInt(formatter.format(currentTime));

        int age = (currentDate-mydob) / 10000;
        return age;
    }
}

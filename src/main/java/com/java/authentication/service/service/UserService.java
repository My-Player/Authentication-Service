package com.java.authentication.service.service;

import com.java.authentication.service.domain.UserData;
import com.java.authentication.service.dto.MessageResponse;
import com.java.authentication.service.dto.UserDTO;
import com.java.authentication.service.dto.UserDataDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

   List<UserData> getUserData();
   UserDTO getUserDetail(String userId);
   MessageResponse editUserDetail(String userId, UserDataDto userDataDto);

}

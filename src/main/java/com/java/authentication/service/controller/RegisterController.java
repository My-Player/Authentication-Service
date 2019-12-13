package com.java.authentication.service.controller;

import com.java.authentication.service.dto.MessageResponse;
import com.java.authentication.service.dto.UserDataDto;
import com.java.authentication.service.dto.UserDataResponse;
import com.java.authentication.service.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
public class RegisterController {

    private final RegisterService registerService;

    @Autowired
    public RegisterController(RegisterService registerService){
        this.registerService = registerService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> postRegister(@RequestBody UserDataResponse userDataResponse){
        MessageResponse messageResponse = registerService.registerUser(userDataResponse);
        return new ResponseEntity(messageResponse, HttpStatus.OK);
    }

}

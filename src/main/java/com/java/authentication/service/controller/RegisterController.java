package com.java.authentication.service.controller;

import com.java.authentication.service.dto.UserRegisterDto;
import com.java.authentication.service.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class RegisterController {

    private final RegisterService registerService;

    @Autowired
    public RegisterController(RegisterService registerService){
        this.registerService = registerService;
    }

    @GetMapping("/register")
    public ResponseEntity<?> postRegister(@RequestBody UserRegisterDto userRegisterDto){
        registerService.registerUser(userRegisterDto);
        return new ResponseEntity(userRegisterDto, HttpStatus.OK);
    }

}

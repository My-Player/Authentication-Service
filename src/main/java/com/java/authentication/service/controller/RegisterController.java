package com.java.authentication.service.controller;

import com.java.authentication.service.dto.Response;
import com.java.authentication.service.dto.UserRegisterDto;
import com.java.authentication.service.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
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
    public ResponseEntity<?> postRegister(@RequestBody UserRegisterDto userRegisterDto){
        Response response = registerService.registerUser(userRegisterDto);
        return new ResponseEntity(response, HttpStatus.OK);
    }

}

package com.java.authentication.service.controller;

import com.java.authentication.service.dto.ErrorResponse;
import com.java.authentication.service.dto.LoginResponse;
import com.java.authentication.service.dto.UserLoginDTO;
import com.java.authentication.service.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/v1")
public class LoginController {

    final LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService){
        this.loginService = loginService;
    }

    @PostMapping(path = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> login(@RequestBody UserLoginDTO userLoginDTO, HttpServletResponse response) throws Exception {
            LoginResponse loginResponse = loginService.loginUser(userLoginDTO, response);
            return new ResponseEntity<>(loginResponse, HttpStatus.OK);
    }

}

package com.java.authentication.service.controller;

import com.java.authentication.service.dto.UserLogin;
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

    @Autowired
    LoginService loginService;

    @PostMapping(path = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> login(@RequestBody UserLogin userLogin, HttpServletResponse response) throws Exception {
        loginService.loginUser(userLogin,response);
        return new ResponseEntity<>(userLogin, HttpStatus.OK);
    }

}

package com.java.authentication.service.controller;

import com.java.authentication.service.dto.OtpDto;
import com.java.authentication.service.service.OtpService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class OtpController {

    final OtpService otpService;

    public OtpController(OtpService otpService) {
        this.otpService = otpService;
    }

    @GetMapping(value = "/generateOtp")
    public ResponseEntity generateOtp(){
        OtpDto response = otpService.generateOtp();
        return new ResponseEntity(response, HttpStatus.OK);
    }
}

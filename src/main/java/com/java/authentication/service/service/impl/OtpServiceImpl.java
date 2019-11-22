package com.java.authentication.service.service.impl;

import com.java.authentication.service.dto.OtpDto;
import com.java.authentication.service.service.OtpService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class OtpServiceImpl implements OtpService {
    @Override
    @Cacheable(cacheNames = "otp")
    public OtpDto generateOtp() {
        OtpDto otpDto = new OtpDto();
        String numbers = "0123456789";
        Random rand = new Random();

        char[] otp = new char[6];
        for(int i=0; i<otp.length;i++){
            otp[i] = numbers.charAt(rand.nextInt(numbers.length()));
        }
        otpDto.setCode(otp);
        return otpDto;
    }
}

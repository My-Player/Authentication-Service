package com.java.authentication.service.service;

import com.java.authentication.service.dto.OtpDto;
import org.springframework.stereotype.Service;

@Service
public interface OtpService {
    OtpDto generateOtp();
}

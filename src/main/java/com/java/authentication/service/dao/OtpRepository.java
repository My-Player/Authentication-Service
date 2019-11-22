package com.java.authentication.service.dao;

import com.java.authentication.service.domain.Otp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OtpRepository extends JpaRepository<Otp,String> {
}

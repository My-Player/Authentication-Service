package com.java.authentication.service.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Otp")
public class Otp {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "otp_id")
    private String otpId;

    @Column(name = "otp_code")
    private int otpCode;

    @Column(name = "is_active")
    private boolean isActive;

    public Otp(int otpCode, boolean isActive) {
        this.otpCode = otpCode;
        this.isActive = isActive;
    }

    public String getOtpId() {
        return otpId;
    }

    public void setOtpId(String otpId) {
        this.otpId = otpId;
    }

    public int getOtpCode() {
        return otpCode;
    }

    public void setOtpCode(int otpCode) {
        this.otpCode = otpCode;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Otp otp = (Otp) o;
        return otpCode == otp.otpCode &&
                isActive == otp.isActive &&
                Objects.equals(otpId, otp.otpId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(otpId, otpCode, isActive);
    }

    @Override
    public String toString() {
        return "Otp{" +
                "otpId='" + otpId + '\'' +
                ", otpCode=" + otpCode +
                ", isActive=" + isActive +
                '}';
    }
}

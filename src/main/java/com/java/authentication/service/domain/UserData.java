package com.java.authentication.service.domain;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "user_data")
@DynamicUpdate
public class UserData implements Serializable {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "user_id")
    private String userId;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "USER_EMAIL")
    private String userEmail;

    @Column(name = "USER_PROVINCE")
    private String userProvince;

    @Column(name = "USER_CITY")
    private String userCity;

    @Column(name = "userPhoto")
    private String userPhoto;

    @Column(name = "USER_PHONE")
    private String userPhone;

    @Column(name = "USER_GENDER")
    private String gender;

    @Column(name = "USER_DOB")
    private Date dob;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATED_AT")
    private Date createdAt;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "LAST_MODIFIED")
    private Date lastModified;

    public UserData() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserProvince() {
        return userProvince;
    }

    public void setUserProvince(String userProvince) {
        this.userProvince = userProvince;
    }

    public String getUserCity() {
        return userCity;
    }

    public void setUserCity(String userCity) {
        this.userCity = userCity;
    }

    public String getUserPhoto() {
        return userPhoto;
    }

    public void setUserPhoto(String userPhoto) {
        this.userPhoto = userPhoto;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserData userData = (UserData) o;
        return userId.equals(userData.userId) &&
                password.equals(userData.password) &&
                userEmail.equals(userData.userEmail) &&
                Objects.equals(userProvince, userData.userProvince) &&
                Objects.equals(userCity, userData.userCity) &&
                Objects.equals(userPhoto, userData.userPhoto) &&
                Objects.equals(userPhone, userData.userPhone) &&
                gender.equals(userData.gender) &&
                dob.equals(userData.dob) &&
                createdAt.equals(userData.createdAt) &&
                lastModified.equals(userData.lastModified);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, password, userEmail, userProvince, userCity, userPhoto, userPhone, gender, dob, createdAt, lastModified);
    }

    @Override
    public String toString() {
        return "UserData{" +
                "userId='" + userId + '\'' +
                ", password='" + password + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userProvince='" + userProvince + '\'' +
                ", userCity='" + userCity + '\'' +
                ", userPhoto='" + userPhoto + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", gender='" + gender + '\'' +
                ", dob=" + dob +
                ", createdAt=" + createdAt +
                ", lastModified=" + lastModified +
                '}';
    }
}

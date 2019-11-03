package com.java.authentication.service.domain;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "users_data")
@DynamicUpdate
public class User implements Serializable {

    @Column(name = "user_id")
    @Id
    private String userId;

    @Column
    private String password;

    @Column(name = "USER_NAME")
    private String userName;

    @Column(name = "USER_RATING")
    private String userRating;

    @Column(name = "USER_EMAIL")
    private String userEmail;

    @Column(name = "USER_PHONE_NUMBER")
    private String userPhoneNumber;

    @Column(name = "USER_ADDRESS")
    private String userAddress;

    @Column(name = "USER_GENDER")
    private String gender;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CLUB_ID")
    private Club club;

    @Column(name = "USER_AGE")
    private int age;

    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserRating() {
        return userRating;
    }

    public void setUserRating(String userRating) {
        this.userRating = userRating;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPhoneNumber() {
        return userPhoneNumber;
    }

    public void setUserPhoneNumber(String userPhoneNumber) {
        this.userPhoneNumber = userPhoneNumber;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

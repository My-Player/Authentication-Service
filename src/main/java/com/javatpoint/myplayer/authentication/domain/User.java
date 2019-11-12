package com.javatpoint.myplayer.authentication.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "my_player_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "seq_user_generator")
    @GenericGenerator(name = "seq_user_generator", strategy = "seq_user")
    @Column(name = "user_id")
    private String userId;

    @Column(name = "user_email")
    private String email;

    @Column(name = "user_password",nullable = false)
    private String password;

    @Column(name = "user_dob")
    private Date dob;

    @Column(name = "user_role")
    private String role;

    @Column(name = "user_address")
    private String address;

    @Column(name = "user_gender", nullable = false)
    private String gender;

    @Column(name = "")





}

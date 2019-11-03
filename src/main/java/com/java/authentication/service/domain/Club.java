package com.java.authentication.service.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "club")
public class Club implements Serializable {

    @Column(name = "club_id")
    @Id
    private String clubId;

    @Column(name = "club_name")
    private String clubName;

    @Column(name = "created_Date")
    private Date createdDate;

    @Column(name = "club_city")
    private String clubCity;

    @Column(name = "club_logo")
    private String clublogo;

    @Column(name = "max_player")
    private String address;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    public String getClubId() {
        return clubId;
    }

    public void setClubId(String clubId) {
        this.clubId = clubId;
    }

    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getClubCity() {
        return clubCity;
    }

    public void setClubCity(String clubCity) {
        this.clubCity = clubCity;
    }

    public String getClublogo() {
        return clublogo;
    }

    public void setClublogo(String clublogo) {
        this.clublogo = clublogo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

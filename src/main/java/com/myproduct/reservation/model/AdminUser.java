package com.myproduct.reservation.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;

@Entity
@Table(name = "adminuser")
@JsonInclude(JsonInclude.Include.NON_NULL)//not understood
@JsonIgnoreProperties(ignoreUnknown = true)//not understood
public class AdminUser {

    @Id
    @Column(name = "id",nullable = false,unique = true)//defining primary key
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "ownerName")
    private String ownerName;

    @Column(name = "phoneNumber")
    private String phoneNumber;

    @Column(name="emailaddress")
    private String emailaddress;

    @Column(name = "password")
    private String password;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailaddress() {
        return emailaddress;
    }

    public void setEmailaddress(String emailaddress) {
        this.emailaddress = emailaddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "AdminUser{" +
                "ownerName='" + ownerName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", emailaddress='" + emailaddress + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

}

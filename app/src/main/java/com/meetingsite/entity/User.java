package com.meetingsite.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.data.relational.core.mapping.Column;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {
    @Id
    private UUID id;
    private String email;
    private String passwordhash;
    private String firstname;
    private String surName;
    private String dadName;
    //private LocalDateTime registrationDate;
    private Boolean isactive;
    private int likesreceived;
    private int matches;
    private UUID addressId; // Связь с Address

    public User(String email, String passwordHash, String surName, String dadName, String firstName) {
        this.email = email;
        this.passwordhash = passwordHash;
        this.firstname = firstName;
        this.dadName = dadName;
        this.surName = surName;
        this.isactive = true;
        //this.registrationDate = registrationDate;
        this.likesreceived = 0;
        this.matches = 0;
    }
}
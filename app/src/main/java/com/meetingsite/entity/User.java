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
    @Column("email")
    private String email;
    @Column("password_hash")
    private String passwordhash;
    @Column("first_name")
    private String firstname;
    @Column("sur_name")
    private String surName;
    @Column("dad_name")
    private String dadName;
    @Column("isactive")
    //private LocalDateTime registrationDate;
    private Boolean isactive;
    @Column("likesreceived")
    private int likesreceived;
    @Column("matches")
    private int matches;
    @Column("address_id")
    private UUID addressId; // Связь с Address
    private Address Address;

    public User(String email, String passwordhash, String surName, String dadName, String firstName) {
        this.email = email;
        this.passwordhash = passwordhash;
        this.firstname = firstName;
        this.dadName = dadName;
        this.surName = surName;
        this.isactive = true;
        //this.registrationDate = registrationDate;
        this.likesreceived = 0;
        this.matches = 0;
    }

}
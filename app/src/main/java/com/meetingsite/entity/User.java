package com.meetingsite.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.UUID;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users") // если таблица называется users
public class User {
    private String email;
    @Id
    private UUID id;
    private String passwordhash;
    private String firstname;
    //private LocalDateTime registrationdate;
    private Boolean isactive;
    private int likesreceived;
    private int matches;
    //private Profile profile;

    public User(String email, String passwordHash, String firstName, LocalDateTime registrationDate) {
        this.email = email;
        this.passwordhash = passwordHash;
        this.firstname = firstName;
        //this.registrationdate = registrationDate;
        this.isactive = true; // По умолчанию активен
        this.likesreceived = 0; // По умолчанию 0
        this.matches = 0; // По умолчанию 0
    }
}
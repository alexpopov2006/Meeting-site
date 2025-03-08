package com.meetingsite.entity;
public class User {
    String email;
    String passwordHash;
    String firstName;
    String registrationDate; // Упрощаем LocalDateTime до String
    boolean isActive;
    int likesReceived;
    int matches;
    Profile profile;

    public User(String email, String passwordHash, String firstName, String registrationDate) {
        this.email = email;
        this.passwordHash = passwordHash;
        this.firstName = firstName;
        this.registrationDate = registrationDate;
        this.isActive = true; // По умолчанию активен
        this.likesReceived = 0; // По умолчанию 0
        this.matches = 0; // По умолчанию 0
    }
}
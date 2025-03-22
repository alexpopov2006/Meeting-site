package com.meetingsite.entity;

public class User {
    private String email;
    private String passwordHash;
    private String firstName;
    private String registrationDate; // Упрощаем LocalDateTime до String
    private Boolean isActive;
    private int likesReceived;
    private int matches;
    private Profile profile;

    public User() {
    }

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
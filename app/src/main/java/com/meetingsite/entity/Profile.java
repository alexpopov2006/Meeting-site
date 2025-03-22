package com.meetingsite.entity;

import java.time.LocalDate;
import java.util.UUID;

public class Profile {
    private UUID id;
    private User user;
    private Gender gender;
    private LocalDate birthDate;
    private String aboutMe;
    private Photo[] photos;

    public enum Gender {
        MALE,
        FEMALE
    }

    public Profile() {
        this.photos = new Photo[0];
    }

    public Profile(UUID id, User user, Gender gender, LocalDate birthDate, String aboutMe, Photo[] photos) {
        this.id = id;
        this.user = user;
        this.gender = gender;
        this.birthDate = birthDate;
        this.aboutMe = aboutMe;
        this.photos = (photos != null) ? photos : new Photo[0];
    }

    // Getters
    public UUID getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Gender getGender() {
        return gender;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getAboutMe() {
        return aboutMe;
    }

    public Photo[] getPhotos() {
        return photos;
    }

    // Setters
    public void setId(UUID id) {
        this.id = id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }

    public void setPhotos(Photo[] photos) {
        this.photos = (photos != null) ? photos : new Photo[0];
    }
}
package com.meetingsite.entity;

import java.util.UUID;

public class Photo {
    private UUID id;
    private Profile profile;
    private String url;
    private Boolean isMain;

    public Photo() {
    }

    public Photo(UUID id, Profile profile, String url, Boolean isMain) {
        this.id = id;
        this.profile = profile;
        this.url = url;
        this.isMain = (isMain != null) ? isMain : false;
    }


    // Getters
    public UUID getId() {
        return id;
    }

    public Profile getProfile() {
        return profile;
    }

    public String getUrl() {
        return url;
    }

    public Boolean getIsMain() {
        return isMain;
    }

    // Setters
    public void setId(UUID id) {
        this.id = id;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setIsMain(Boolean isMain) {
        this.isMain = (isMain != null) ? isMain : false;
    }
}
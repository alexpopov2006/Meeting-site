package com.meetingsite.entity;
public class Photo {
    Profile profile;
    String url;
    boolean isMain;

    public Photo(Profile profile, String url) {
        this.profile = profile;
        this.url = url;
        this.isMain = false; // По умолчанию не основное
    }
}
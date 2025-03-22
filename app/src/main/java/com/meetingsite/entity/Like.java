package com.meetingsite.entity;

import java.time.LocalDateTime;
import java.util.UUID;

public class Like {
    private UUID id;
    private User liker;
    private User likedUser;
    private LocalDateTime likeDate;

    public Like(UUID id, User liker, User likedUser, LocalDateTime likeDate) {
        this.id = id;
        this.liker = liker;
        this.likedUser = likedUser;
        this.likeDate = likeDate;
    }
    public Like() {
    }

    // Getters
    public UUID getId() {
        return id;
    }

    public User getLiker() {
        return liker;
    }

    public User getLikedUser() {
        return likedUser;
    }

    public LocalDateTime getLikeDate() {
        return likeDate;
    }

    // Setters
    public void setId(UUID id) {
        this.id = id;
    }

    public void setLiker(User liker) {
        this.liker = liker;
    }

    public void setLikedUser(User likedUser) {
        this.likedUser = likedUser;
    }

    public void setLikeDate(LocalDateTime likeDate) {
        this.likeDate = likeDate;
    }
}
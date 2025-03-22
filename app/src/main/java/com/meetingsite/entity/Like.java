package com.meetingsite.entity;
public class Like {
    private User liker;
    private User likedUser;
    private String likeDate; // Упрощаем LocalDateTime до String

    public Like(User liker, User likedUser, String likeDate) {
        this.liker = liker;
        this.likedUser = likedUser;
        this.likeDate = likeDate;
    }
}
package com.meetingsite.entity;
public class Block {
    User blocker;
    User blockedUser;
    String blockDate; // Упрощаем LocalDateTime до String

    public Block(User blocker, User blockedUser, String blockDate) {
        this.blocker = blocker;
        this.blockedUser = blockedUser;
        this.blockDate = blockDate;
    }
}
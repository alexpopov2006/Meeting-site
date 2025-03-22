package com.meetingsite.entity;

import java.time.LocalDateTime;

public class Block {
    private User blocker;
    private User blockedUser;
    private LocalDateTime blockDate;

    public Block(User blocker, User blockedUser, LocalDateTime blockDate) {
        this.blocker = blocker;
        this.blockedUser = blockedUser;
        this.blockDate = blockDate;
    }
}
package com.meetingsite.entity;

import java.time.LocalDateTime;
import java.util.UUID;

public class Block {
    private UUID id;
    private User blocker;
    private User blockedUser;
    private LocalDateTime blockDate;

    public Block(UUID id, User blocker, User blockedUser, LocalDateTime blockDate) {
        this.id = id;
        this.blocker = blocker;
        this.blockedUser = blockedUser;
        this.blockDate = blockDate;
    }

    // Getters
    public UUID getId() {
        return id;
    }

    public User getBlocker() {
        return blocker;
    }

    public User getBlockedUser() {
        return blockedUser;
    }

    public LocalDateTime getBlockDate() {
        return blockDate;
    }

    // Setters
    public void setId(UUID id) {
        this.id = id;
    }

    public void setBlocker(User blocker) {
        this.blocker = blocker;
    }

    public void setBlockedUser(User blockedUser) {
        this.blockedUser = blockedUser;
    }

    public void setBlockDate(LocalDateTime blockDate) {
        this.blockDate = blockDate;
    }
}
package com.meetingsite.entity;

import java.time.LocalDateTime;
import java.util.UUID;

public class Message {
    private UUID id;
    private User sender;
    private User receiver;
    private String content;
    private LocalDateTime sentDate;

    public Message(UUID id, User sender, User receiver, String content, LocalDateTime sentDate) {
        this.id = id;
        this.sender = sender;
        this.receiver = receiver;
        this.content = content;
        this.sentDate = sentDate;
    }

    // Getters
    public UUID getId() {
        return id;
    }

    public User getSender() {
        return sender;
    }

    public User getReceiver() {
        return receiver;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getSentDate() {
        return sentDate;
    }

    // Setters
    public void setId(UUID id) {
        this.id = id;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setSentDate(LocalDateTime sentDate) {
        this.sentDate = sentDate;
    }
}
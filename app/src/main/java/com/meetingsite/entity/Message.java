package com.meetingsite.entity;
public class Message {
    private User sender;
    private User receiver;
    private String content;
    private String sentDate; // Упрощаем LocalDateTime до String

    public Message(User sender, User receiver, String content, String sentDate) {
        this.sender = sender;
        this.receiver = receiver;
        this.content = content;
        this.sentDate = sentDate;
    }
}
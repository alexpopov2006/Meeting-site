package com.meetingsite.entity;
public class Message {
    User sender;
    User receiver;
    String content;
    String sentDate; // Упрощаем LocalDateTime до String

    public Message(User sender, User receiver, String content, String sentDate) {
        this.sender = sender;
        this.receiver = receiver;
        this.content = content;
        this.sentDate = sentDate;
    }
}
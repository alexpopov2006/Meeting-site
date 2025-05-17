package com.meetingsite.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
import java.util.UUID;
@Getter
@Setter
@NoArgsConstructor
public class Message {
    @Id
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
}
package com.meetingsite.service;

import com.meetingsite.entity.Message;
import com.meetingsite.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public Message saveMessage(Message message) {
        return messageRepository.save(message);
    }
}
package com.meetingsite.service;

import com.meetingsite.entity.Message;
import com.meetingsite.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public Message sendMessage(UUID senderId, UUID receiverId, String content, LocalDateTime sentDate) {
        Message message = new Message();
        message.setSenderId(senderId);
        message.setReceiverId(receiverId);
        message.setContent(content);
        message.setSentDate(LocalDateTime.now());
        return messageRepository.save(message);
    }
    public List<Message> getMessagesByUserId(Long userId) {
        return messageRepository.findBySenderIdOrReceiverId(userId, userId);
    }

}
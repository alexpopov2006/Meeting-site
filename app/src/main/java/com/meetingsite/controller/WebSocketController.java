package com.meetingsite.controller;

import com.meetingsite.entity.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketController {

    private static final Logger logger = LoggerFactory.getLogger(WebSocketController.class);

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @MessageMapping("/sendMessage")
    public void handleMessage(Message message) {
        logger.info("Received WebSocket message from {} to {}", message.getSenderId(), message.getReceiverId());
        messagingTemplate.convertAndSend("/topic/messages/" + message.getReceiverId(), message);
    }

}
package com.meetingsite.dto.request;

import com.meetingsite.entity.User;
import java.time.LocalDateTime;
import java.util.UUID;

public record MessageRequest(
        UUID id,
        User sender,
        User receiver,
        String content,
        LocalDateTime sentDate
) {
}

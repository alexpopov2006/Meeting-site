package com.meetingsite.dto.response;

import com.meetingsite.entity.User;
import java.time.LocalDateTime;
import java.util.UUID;

public record MessageResponse(
        UUID id,
        User sender,
        User receiver,
        String content,
        LocalDateTime sentDate
) {
}

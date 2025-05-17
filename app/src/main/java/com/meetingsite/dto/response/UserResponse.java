package com.meetingsite.dto.response;

import java.time.LocalDateTime;
import java.util.UUID;

public record UserResponse(
        String email,
        UUID id,
        String firstName,
        LocalDateTime registrationDate,
        Boolean isActive,
        Integer likesReceived,
        Integer matches
) {
}
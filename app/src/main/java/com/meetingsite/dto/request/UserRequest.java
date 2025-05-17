package com.meetingsite.dto.request;

import java.time.LocalDateTime;
import java.util.UUID;

public record UserRequest(
        String email,
        UUID id,
        String passwordHash,
        String firstName,
        LocalDateTime registrationDate,
        Boolean isActive,
        Integer likesReceived,
        Integer matches
) {
}
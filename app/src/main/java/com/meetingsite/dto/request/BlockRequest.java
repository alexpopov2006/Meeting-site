package com.meetingsite.dto.request;

import com.meetingsite.entity.User;
import java.time.LocalDateTime;
import java.util.UUID;

public record BlockRequest(
        UUID id,
        User blocker,
        User blockedUser,
        LocalDateTime blockDate
) {
}

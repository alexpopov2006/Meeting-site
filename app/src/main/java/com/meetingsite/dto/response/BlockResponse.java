package com.meetingsite.dto.response;

import com.meetingsite.entity.User;
import java.time.LocalDateTime;
import java.util.UUID;

public record BlockResponse(
        UUID id,
        User blocker,
        User blockedUser,
        LocalDateTime blockDate
) {
}

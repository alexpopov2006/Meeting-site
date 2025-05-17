package com.meetingsite.dto.response;

import com.meetingsite.entity.User;
import java.time.LocalDateTime;
import java.util.UUID;

public record LikeResponse(
        UUID id,
        User liker,
        User likedUser,
        LocalDateTime likeDate
) {
}

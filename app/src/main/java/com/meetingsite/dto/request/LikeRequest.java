package com.meetingsite.dto.request;

import com.meetingsite.entity.User;
import java.time.LocalDateTime;
import java.util.UUID;

public record LikeRequest(
        UUID id,
        User liker,
        User likedUser,
        LocalDateTime likeDate
) {
}

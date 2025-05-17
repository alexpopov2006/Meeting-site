package com.meetingsite.dto.request;
import com.meetingsite.entity.Profile;
import java.util.UUID;

public record ProfileRequest(
        UUID id,
        Profile profile,
        String url,
        Boolean isMain
) {
}
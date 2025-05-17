package com.meetingsite.dto.request;

import com.meetingsite.entity.Photo;
import com.meetingsite.entity.User;
import com.meetingsite.enums.Gender;
import java.time.LocalDate;
import java.util.UUID;

public record PhotoRequest(
        UUID id,
        User user,
        Gender gender,
        LocalDate birthDate,
        String aboutMe,
        Photo[] photos
) {
}

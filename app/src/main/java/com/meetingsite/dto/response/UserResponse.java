package com.meetingsite.dto.response;

import java.time.LocalDateTime;
import java.util.UUID;

public record UserResponse(
        String email,
        UUID id,
        String firstName,
        String surName,
        String dadName,
        //LocalDateTime registrationDate,
        Boolean isActive,
        Integer likesReceived,
        Integer matches,
        AddressResponse address // Добавляем адрес
) {
    public record AddressResponse(
            String country,
            String region,
            String city
    ) {}
}
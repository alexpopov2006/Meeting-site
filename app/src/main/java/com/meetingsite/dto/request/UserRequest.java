package com.meetingsite.dto.request;

import java.time.LocalDateTime;
import java.util.UUID;

public record UserRequest(
        String email,
        UUID id,
        String passwordHash,
        String firstName,
        String surName,
        String dadName,
        //LocalDateTime registrationDate,
        Boolean isActive,
        Integer likesReceived,
        Integer matches,
        AddressRequest address // Добавляем адрес
) {
    public record AddressRequest(
            String country,
            String region,
            String city
    ) {}
}
package com.meetingsite.mapper;

import com.meetingsite.dto.request.UserRequest;
import com.meetingsite.entity.Address;
import com.meetingsite.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;
import static org.mapstruct.ReportingPolicy.ERROR;

@Mapper(unmappedTargetPolicy = ERROR, componentModel = SPRING)
public interface UserMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "passwordhash", ignore = true)  // или замаппить, если поле есть в UserRequest
    @Mapping(target = "firstname", ignore = true)     // или замаппить, если поле есть в UserRequest
    @Mapping(target = "isactive", ignore = true)      // или замаппить, если поле есть в UserRequest
    @Mapping(target = "likesreceived", ignore = true) // или замаппить, если поле есть в UserRequest
    @Mapping(target = "addressId", ignore = true)      // или замаппить, если поле есть в UserRequest
    User toEntity(UserRequest request);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "country", source = "address.country")
    @Mapping(target = "region", ignore = true)        // или замаппить, если поле есть в UserRequest
    @Mapping(target = "city", ignore = true)         // или замаппить, если поле есть в UserRequest
    Address toAddress(UserRequest request);
}
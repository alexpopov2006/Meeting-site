package com.meetingsite.mapper;

import com.meetingsite.dto.request.UserRequest;
import com.meetingsite.dto.response.UserResponse;
import com.meetingsite.entity.Address;
import com.meetingsite.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User toEntity(UserRequest request) {
        User user = new User(
                request.email(),
                request.passwordHash(),
                request.surName(),
                request.dadName(),
                request.firstName()
        );
        user.setIsactive(request.isActive());
        user.setLikesreceived(request.likesReceived());
        user.setMatches(request.matches());
        if (request.address() != null) {
            user.setAddress(new Address(
                    request.address().country(),
                    request.address().region(),
                    request.address().city()
            ));
        }
        return user;
    }

    public Address toAddress(UserRequest request) {
        if (request.address() == null) {
            return null;
        }
        return new Address(
                request.address().country(),
                request.address().region(),
                request.address().city()
        );
    }

    public UserResponse toResponse(User user, Address address) {
        UserResponse.AddressResponse addressResponse = null;
        if (address != null) {
            addressResponse = new UserResponse.AddressResponse(
                    address.getCountry(),
                    address.getRegion(),
                    address.getCity()
            );
        }
        return new UserResponse(
                user.getEmail(),
                user.getId(),
                user.getFirstname(),
                user.getSurName(),
                user.getDadName(),
                user.getIsactive(),
                user.getLikesreceived(),
                user.getMatches(),
                addressResponse
        );
    }

    // Новый метод для обновления сущности User из UserRequest
    public void updateEntityFromRequest(UserRequest request, User userToUpdate) {
        userToUpdate.setEmail(request.email());
        userToUpdate.setSurName(request.surName());
        userToUpdate.setDadName(request.dadName());
        userToUpdate.setFirstname(request.firstName());
        userToUpdate.setIsactive(request.isActive());
        userToUpdate.setLikesreceived(request.likesReceived());
        userToUpdate.setMatches(request.matches());
        // Игнорируем поле адреса здесь, так как оно обрабатывается в сервисе
    }
}

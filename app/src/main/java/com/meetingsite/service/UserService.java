package com.meetingsite.service;

import com.meetingsite.dto.request.UserRequest;
import com.meetingsite.dto.response.UserResponse;
import com.meetingsite.entity.Address;
import com.meetingsite.entity.User;
import com.meetingsite.mapper.UserMapper;
import com.meetingsite.repository.AddressRepository;
import com.meetingsite.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final AddressRepository addressRepository;
    private final UserMapper userMapper;

    public UserMapper getMapper() {
        return userMapper;
    }

    @Transactional
    public UserResponse createUser(UserRequest request) {
        if (userRepository.existsByEmail(request.email())) {
            throw new IllegalArgumentException("Email already exists");
        }
        Address savedAddress = null;
        if (request.address() != null) {
            var address = userMapper.toAddress(request);
            savedAddress = addressRepository.save(address);
        }
        var user = userMapper.toEntity(request); // Преобразуем UserRequest в User
        user.setAddressId(savedAddress == null ? null : savedAddress.getId());
        User savedUser = userRepository.save(user); // Сохраняем User
        return userMapper.toResponse(savedUser, savedAddress); // Возвращаем UserResponse
    }

    public Optional<User> getUserById(UUID id) {
        return userRepository.findById(id);
    }

    public Page<User> getAllUsers(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Transactional
    public UserResponse updateUser(UUID id, UserRequest userRequest) {
        Optional<User> existingUser = userRepository.findById(id);
        if (existingUser.isEmpty()) {
            throw new IllegalArgumentException("User not found");
        }
        var user = userMapper.toEntity(userRequest); // Преобразуем UserRequest в User
        user.setId(id);
        if (user.getAddress() != null) {
            Address savedAddress = addressRepository.save(user.getAddress());
            user.setAddress(savedAddress);
        }
        User savedUser = userRepository.save(user);
        return userMapper.toResponse(savedUser, savedUser.getAddress());
    }

    @Transactional
    public void deleteUser(UUID id) {
        if (!userRepository.existsById(id)) {
            throw new IllegalArgumentException("User not found");
        }
        userRepository.deleteById(id);
    }
}
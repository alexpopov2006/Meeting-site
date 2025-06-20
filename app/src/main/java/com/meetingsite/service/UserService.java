package com.meetingsite.service;

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

    @Transactional
    public User createUser(User request) {
        if (userRepository.existsByEmail(request.email())) {
            throw new IllegalArgumentException("Email already exists");
        }
        Address savedAddress = null;
        // Сохраняем адрес, если он указан
        if (request.address() != null) {
            var address = userMapper.toAddress(request);
            savedAddress = addressRepository.save(address);
        }
        var user = userMapper.toEntity(request);
        user.setAddressId(savedAddress == null ? null : savedAddress.getId());
        return userMapper.toResponse(userRepository.save(request), savedAddress); //сделать в маппере метод этот
    }
    public Optional<User> getUserById(UUID id) {
        return userRepository.findById(id);
    }
    public Page<User> getAllUsers(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Transactional
    public User updateUser(UUID id, User userDetails) {
        Optional<User> existingUser = userRepository.findById(id);
        if (existingUser.isEmpty()) {
            throw new IllegalArgumentException("User not found");
        }
        userDetails.setId(id);
        // Обновляем адрес, если он указан
        if (userDetails.getAddress() != null) {
            Address savedAddress = addressRepository.save(userDetails.getAddress());
            userDetails.setAddress(savedAddress);
        }
        return userRepository.save(userDetails);
    }

    @Transactional
    public void deleteUser(UUID id) {
        if (!userRepository.existsById(id)) {
            throw new IllegalArgumentException("User not found");
        }
        userRepository.deleteById(id);
    }
}
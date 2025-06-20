package com.meetingsite.controller;

import com.meetingsite.dto.request.UserRequest;
import com.meetingsite.dto.response.UserResponse;
import com.meetingsite.entity.Address;
import com.meetingsite.entity.User;
import com.meetingsite.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/users")
@Tag(name = "Пользователи", description = "API для управления пользователями")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    @Operation(summary = "Создать пользователя", description = "Создаёт нового пользователя на основе переданных данных (только для модераторов и админов)")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Пользователь успешно создан"),
            @ApiResponse(responseCode = "400", description = "Неверные данные запроса"),
            @ApiResponse(responseCode = "403", description = "Доступ запрещён")
    })
    public UserResponse createUser(@Valid @RequestBody UserRequest userRequest) {
        User user = mapToEntity(userRequest);
        User createdUser = userService.createUser(user);
        return mapToResponse(createdUser);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Получить пользователя по ID", description = "Возвращает пользователя по указанному ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Пользователь найден"),
            @ApiResponse(responseCode = "404", description = "Пользователь не найден")
    })
    public ResponseEntity<UserResponse> getUserById(@PathVariable UUID id) {
        return userService.getUserById(id)
                .map(user -> ResponseEntity.ok(mapToResponse(user)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    @Operation(summary = "Получить всех пользователей", description = "Возвращает список всех пользователей")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Список пользователей успешно получен")
    })
    public Page<UserResponse> getAllUsers(@ParameterObject @PageableDefault Pageable pageable) {
        return userService.getAllUsers(pageable).map(this::mapToResponse);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Обновить пользователя", description = "Обновляет данные пользователя по указанному ID (только для модераторов и админов)")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Пользователь успешно обновлён"),
            @ApiResponse(responseCode = "400", description = "Неверные данные запроса"),
            @ApiResponse(responseCode = "403", description = "Доступ запрещён"),
            @ApiResponse(responseCode = "404", description = "Пользователь не найден")
    })
    public ResponseEntity<UserResponse> updateUser(@PathVariable UUID id, @Valid @RequestBody UserRequest userRequest) {
        User user = mapToEntity(userRequest);
        User updatedUser = userService.updateUser(id, user);
        return ResponseEntity.ok(mapToResponse(updatedUser));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Удалить пользователя", description = "Удаляет пользователя по указанному ID (только для модераторов и админов)")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Пользователь успешно удалён"),
            @ApiResponse(responseCode = "403", description = "Доступ запрещён"),
            @ApiResponse(responseCode = "404", description = "Пользователь не найден")
    })
    public ResponseEntity<Void> deleteUser(@PathVariable UUID id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
    private User mapToEntity(UserRequest request) {
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
    private UserResponse mapToResponse(User user) {
        UserResponse.AddressResponse addressResponse = null;
        if (user.getAddress() != null) {
            addressResponse = new UserResponse.AddressResponse(
                    user.getAddress().getCountry(),
                    user.getAddress().getRegion(),
                    user.getAddress().getCity()
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
}
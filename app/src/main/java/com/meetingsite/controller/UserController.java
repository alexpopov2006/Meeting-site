package com.meetingsite.controller;

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
    public User createUser(@Valid @RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Получить пользователя по ID", description = "Возвращает пользователя по указанному ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Пользователь найден"),
            @ApiResponse(responseCode = "404", description = "Пользователь не найден")
    })
    public ResponseEntity<User> getUserById(@PathVariable UUID id) {
        return userService.getUserById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    @Operation(summary = "Получить всех пользователей", description = "Возвращает список всех пользователей")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Список пользователей успешно получен")
    })
    public Page<User> getAllUsers(@ParameterObject @PageableDefault Pageable pageable) {
        return userService.getAllUsers(pageable);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Обновить пользователя", description = "Обновляет данные пользователя по указанному ID (только для модераторов и админов)")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Пользователь успешно обновлён"),
            @ApiResponse(responseCode = "400", description = "Неверные данные запроса"),
            @ApiResponse(responseCode = "403", description = "Доступ запрещён"),
            @ApiResponse(responseCode = "404", description = "Пользователь не найден")
    })
    public ResponseEntity<User> updateUser(@PathVariable UUID id, @Valid @RequestBody User userDetails) {
        User updatedUser = userService.updateUser(id, userDetails);
        return ResponseEntity.ok(updatedUser);
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
}
package com.meetingsite.controller;

import com.meetingsite.entity.Message;
import com.meetingsite.service.MessageService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/messages")
@ControllerAdvice
public class MessagesController {

    @Autowired
    private MessageService messageService;

    @Operation(summary = "Отправить сообщение", description = "Отправляет сообщение от одного пользователя другому")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Сообщение успешно отправлено",
                    content = @Content(schema = @Schema(implementation = Message.class))),
            @ApiResponse(responseCode = "400", description = "Неверный формат JSON")
    })
    @PostMapping("/send")
    public ResponseEntity<Message> sendMessage(@RequestBody Message message) {
        Message savedMessage = messageService.saveMessage(message);
        return ResponseEntity.ok(savedMessage);
    }


    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<String> handleJsonParseError(HttpMessageNotReadableException ex) {
        return new ResponseEntity<>("Invalid JSON format: " + ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
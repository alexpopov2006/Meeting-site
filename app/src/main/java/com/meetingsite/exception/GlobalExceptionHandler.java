package com.meetingsite.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(OperationNotAllowedException.class)
  public ResponseEntity<String> handleOperationNotAllowedException(OperationNotAllowedException ex) {
    // Возвращаем статус 403 Forbidden и сообщение исключения
    return ResponseEntity.status(HttpStatus.FORBIDDEN).body(ex.getMessage());
    // Или можно вернуть 400 Bad Request, в зависимости от контекста
    // return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
  }

  // Можете добавить обработчики для других ваших исключений здесь
  // @ExceptionHandler(UserNotFoundException.class)
  // public ResponseEntity<String> handleUserNotFoundException(UserNotFoundException ex) {
  //     return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
  // }

  // @ExceptionHandler(EmailAlreadyExistsException.class)
  // public ResponseEntity<String> handleEmailAlreadyExistsException(EmailAlreadyExistsException ex) {
  //     return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage()); // 409 Conflict
  // }
}

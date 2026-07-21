package com.abhishek.demo.StudentServer.Exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> validationException(
            MethodArgumentNotValidException ex) {

        return ResponseEntity.badRequest().body(
                ex.getBindingResult().getFieldError().getDefaultMessage()
        );
    }

    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<String> studentNotFound(
            StudentNotFoundException ex) {

        return ResponseEntity.status(404).body(ex.getMessage());
    }
}
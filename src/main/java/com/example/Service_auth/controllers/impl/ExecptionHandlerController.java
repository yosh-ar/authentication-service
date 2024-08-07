package com.example.Service_auth.controllers.impl;

import com.example.Service_auth.commons.dtos.ErrorResponse;
import com.example.Service_auth.commons.exceptions.AuthException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class ExecptionHandlerController {
    @ExceptionHandler({MethodArgumentNotValidException.class, AuthException.class})
    public ResponseEntity<Object> handleExceptions(Exception ex) {
    AuthException authException = (AuthException) ex;
    ErrorResponse errorResponse = ErrorResponse.builder()
            .code(authException.getHttpStatus().value())
            .message(authException.getMessage())
            .build();
            return new ResponseEntity<>(errorResponse, authException.getHttpStatus());
    }
}

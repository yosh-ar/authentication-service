package com.example.Service_auth.commons.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class AuthException extends  RuntimeException{
    private HttpStatus httpStatus;

    public AuthException(HttpStatus httpStatus,String message) {
        super(message);
        this.httpStatus = httpStatus;
    }
}

package com.example.Service_auth.controllers.impl;

import com.example.Service_auth.commons.dtos.TokenResponse;
import com.example.Service_auth.commons.dtos.UserRequest;
import com.example.Service_auth.controllers.AuthApi;
import com.example.Service_auth.services.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController implements AuthApi {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @Override
    public ResponseEntity<TokenResponse> createUser(UserRequest userRequest) {
        return ResponseEntity.ok(authService.createUser(userRequest));
    }
}

package com.example.Service_auth.services;

import com.example.Service_auth.commons.dtos.TokenResponse;
import com.example.Service_auth.commons.dtos.UserRequest;

public interface AuthService {
    TokenResponse createUser(UserRequest userRequest);
    TokenResponse login(String email, String password);
}

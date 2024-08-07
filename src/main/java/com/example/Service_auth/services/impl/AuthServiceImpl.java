package com.example.Service_auth.services.impl;

import com.example.Service_auth.commons.dtos.TokenResponse;
import com.example.Service_auth.commons.dtos.UserRequest;
import com.example.Service_auth.commons.entities.UserModel;
import com.example.Service_auth.commons.exceptions.AuthException;
import com.example.Service_auth.repositories.UserRepository;
import com.example.Service_auth.services.AuthService;
import com.example.Service_auth.services.JwtService;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;

    public AuthServiceImpl(UserRepository userRepository, JwtService jwtService, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.jwtService = jwtService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public TokenResponse createUser(UserRequest userRequest) {
        return Optional.of(userRequest)
                .map(this::mapToEntity)
                .map(userRepository::save)
                .map(userCreated -> jwtService.generateToken(userCreated.getId()))
                .orElseThrow(() -> new AuthException(HttpStatus.NOT_FOUND,"Error creating user"));
    }

    @Override
    public TokenResponse login(String email, String password) {
        var response = userRepository.findByEmail(email)
                .filter(user -> passwordEncoder.matches(password, user.getPassword()))
                .map(user -> jwtService.generateToken(user.getId()))
                .orElseThrow(() -> new AuthException(HttpStatus.NOT_FOUND,"Invalid credentials"));
        return response;
    }

    private UserModel mapToEntity(UserRequest userRequest) {
        return  UserModel.builder()
                .email(userRequest.getEmail())
                .password(passwordEncoder.encode(userRequest.getPassword()))
                .role("USER")
                .build();
    }
}

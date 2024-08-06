package com.example.Service_auth.services;

import com.example.Service_auth.commons.dtos.TokenResponse;
import io.jsonwebtoken.Claims;

import java.time.Instant;

public interface JwtService {
    TokenResponse generateToken(Long userId);
    Claims getClaims(String token);
    boolean isTokenExpired(String token);
    Integer extractUserId(String token);

}

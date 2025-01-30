package com.farid.portfolio_api.controller;

import com.farid.portfolio_api.dto.request.AuthRequest;
import com.farid.portfolio_api.dto.request.RegisterRequest;
import com.farid.portfolio_api.dto.response.AuthResponse;
import com.farid.portfolio_api.service.serviceImpl.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }
}

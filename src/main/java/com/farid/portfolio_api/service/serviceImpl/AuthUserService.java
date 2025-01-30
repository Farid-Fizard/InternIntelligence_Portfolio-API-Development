package com.farid.portfolio_api.service.serviceImpl;

import com.farid.portfolio_api.entity.User;
import com.farid.portfolio_api.repository.UserRepository;
import com.farid.portfolio_api.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthUserService {
    private final JwtUtil jwtUtil;
    private final UserRepository userRepository;

    public User getAuthenticatedUser(String token) {
        String jwtToken = jwtUtil.extractTokenFromHeader(token);
        Long userId = jwtUtil.extractUserId(jwtToken);
        return userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
}


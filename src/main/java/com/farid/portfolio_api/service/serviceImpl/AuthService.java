package com.farid.portfolio_api.service.serviceImpl;
import com.farid.portfolio_api.dto.request.AuthRequest;
import com.farid.portfolio_api.dto.request.RegisterRequest;
import com.farid.portfolio_api.dto.response.AuthResponse;
import com.farid.portfolio_api.entity.User;
import com.farid.portfolio_api.repository.UserRepository;
import com.farid.portfolio_api.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;

    public AuthResponse register(RegisterRequest request) {
        User user = new User();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        user.setProjects(new ArrayList<>());
        user.setExperiences(new ArrayList<>());
        user.setEducations(new ArrayList<>());
        user.setSkills(new ArrayList<>());

        userRepository.save(user);

        String token = jwtUtil.generateToken(user.getEmail(),user.getId());
        return new AuthResponse(token);
    }

    public AuthResponse login(AuthRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        String token = jwtUtil.generateToken(user.getEmail(),user.getId());
        return new AuthResponse(token);
    }
}

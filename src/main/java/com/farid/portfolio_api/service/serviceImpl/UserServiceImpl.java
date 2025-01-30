package com.farid.portfolio_api.service.serviceImpl;

import com.farid.portfolio_api.dto.request.UserRequest;
import com.farid.portfolio_api.dto.response.UserResponse;
import com.farid.portfolio_api.entity.User;
import com.farid.portfolio_api.mapper.UserMapper;
import com.farid.portfolio_api.repository.UserRepository;
import com.farid.portfolio_api.service.UserService;
import com.farid.portfolio_api.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;
    private final UserMapper userMapper;

    private Long validateUserId(Long id, String token) {
        String jwtToken= jwtUtil.extractTokenFromHeader(token);
        Long userId = jwtUtil.extractUserId(jwtToken);
        if (userId == null) {
            throw new RuntimeException("Token is invalid");
        }
        if (!userId.equals(id)) {
            throw new RuntimeException("Access denied: You can only access your own data");
        }

        return userId;
    }

    @Override
    public UserResponse getUserById(Long id, String token) {
        validateUserId(id, token);
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return userMapper.toResponse(user);
    }

    @Override
    public UserResponse updateUser(Long id, UserRequest request, String token) {
        validateUserId(id, token);
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        userMapper.updateUserFromDto(request, existingUser);
        User updatedUser = userRepository.save(existingUser);

        return userMapper.toResponse(updatedUser);
    }

    @Override
    public void deleteUser(Long id, String token) {
        validateUserId(id, token);
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        userRepository.delete(user);
    }
}


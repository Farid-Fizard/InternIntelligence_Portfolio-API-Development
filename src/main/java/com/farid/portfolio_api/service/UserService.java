package com.farid.portfolio_api.service;

import com.farid.portfolio_api.dto.request.UserRequest;
import com.farid.portfolio_api.dto.response.UserResponse;

import java.util.List;


public interface UserService {
    UserResponse getUserById(Long id, String token);
    UserResponse updateUser(Long id, UserRequest request, String token);

    void deleteUser(Long id, String token);
}

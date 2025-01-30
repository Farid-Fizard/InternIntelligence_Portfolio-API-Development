package com.farid.portfolio_api.controller;

import com.farid.portfolio_api.dto.request.UserRequest;
import com.farid.portfolio_api.dto.response.UserResponse;
import com.farid.portfolio_api.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable Long id,
                                                    @RequestHeader("Authorization") String token) {
        System.out.println(token);
        UserResponse user = userService.getUserById(id, token);
        return ResponseEntity.ok(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponse> updateUser(@PathVariable Long id,
                                                   @RequestBody UserRequest request,
                                                   @RequestHeader("Authorization") String token) {

        UserResponse updatedUser = userService.updateUser(id, request, token);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id,
                                           @RequestHeader("Authorization") String token) {
        userService.deleteUser(id, token);
        return ResponseEntity.noContent().build();
    }
}

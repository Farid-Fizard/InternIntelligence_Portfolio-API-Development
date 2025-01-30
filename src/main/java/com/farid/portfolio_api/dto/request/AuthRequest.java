package com.farid.portfolio_api.dto.request;

import lombok.Data;

@Data
public class AuthRequest {
    private String email;
    private String password;

}

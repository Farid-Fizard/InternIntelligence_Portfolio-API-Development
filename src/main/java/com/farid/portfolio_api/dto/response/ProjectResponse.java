package com.farid.portfolio_api.dto.response;

import com.farid.portfolio_api.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectResponse {
    private Long id;
    private String name;
    private String description;
    private String technologiesUsed;
    private String url;
    private UserResponse userResponse;
}

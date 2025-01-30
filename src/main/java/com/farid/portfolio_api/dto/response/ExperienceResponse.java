package com.farid.portfolio_api.dto.response;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExperienceResponse {
    private Long id;
    private String company;
    private String role;
    private LocalDate startDate;
    private LocalDate endDate;
    private UserResponse userResponse;

}

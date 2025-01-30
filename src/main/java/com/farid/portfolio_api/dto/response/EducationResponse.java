package com.farid.portfolio_api.dto.response;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EducationResponse {
    private Long id;
    private String institution;
    private String degree;
    private  String major;
    private Double  gpa;
    private LocalDate startDate;
    private LocalDate endDate;
    private UserResponse userResponse;

}

package com.farid.portfolio_api.dto.request;

import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExperienceRequest {
    private String company;
    private String role;
    private LocalDate startDate;
    private LocalDate endDate;

}

package com.farid.portfolio_api.dto.request;

import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EducationRequest {
    private String institution;
    private String degree;
    private  String major;
    private Double  gpa;
    private LocalDate startDate;
    private LocalDate endDate;

}

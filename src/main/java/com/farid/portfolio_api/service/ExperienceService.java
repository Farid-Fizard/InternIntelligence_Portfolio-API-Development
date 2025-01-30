package com.farid.portfolio_api.service;

import com.farid.portfolio_api.dto.request.ExperienceRequest;
import com.farid.portfolio_api.dto.response.ExperienceResponse;

import java.util.List;

public interface ExperienceService {
    ExperienceResponse createExperience(ExperienceRequest request, String token);
    ExperienceResponse getExperienceById(Long id, String token);
    List<ExperienceResponse> getAllExperiences(String token);
    ExperienceResponse updateExperience(Long id, ExperienceRequest request, String token);
    void deleteExperience(Long id, String token);
}

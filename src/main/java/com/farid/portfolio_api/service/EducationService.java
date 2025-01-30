package com.farid.portfolio_api.service;

import com.farid.portfolio_api.dto.request.EducationRequest;
import com.farid.portfolio_api.dto.response.EducationResponse;

import java.util.List;

public interface EducationService {
    EducationResponse createEducation(EducationRequest request, String token);
    EducationResponse getEducationById(Long id,String token);
    List<EducationResponse> getAllEducations(String token);
    EducationResponse updateEducation(Long id,EducationRequest request,String token);

    void deleteEducation(Long id,String token);
}

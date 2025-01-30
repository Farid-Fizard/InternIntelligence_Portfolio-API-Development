package com.farid.portfolio_api.mapper;

import com.farid.portfolio_api.dto.request.EducationRequest;
import com.farid.portfolio_api.dto.response.EducationResponse;
import com.farid.portfolio_api.dto.response.UserResponse;
import com.farid.portfolio_api.entity.Education;
import org.springframework.stereotype.Component;

@Component
public class EducationMapper {
    public Education toEntity(EducationRequest request){
        Education education= new Education();
        education.setInstitution(request.getInstitution());
        education.setDegree(request.getDegree());
        education.setMajor(request.getMajor());
        education.setGpa(request.getGpa());
        education.setStartDate(request.getStartDate());
        education.setEndDate(request.getEndDate());
        return education;
    }
    public EducationResponse toResponse(Education education){

        UserResponse userResponse = new UserResponse(
                education.getUser().getId(),
                education.getUser().getUsername(),
                education.getUser().getEmail()
        );

        EducationResponse response= new EducationResponse();
        response.setId(education.getId());
        response.setInstitution(education.getInstitution());
        response.setDegree(education.getDegree());
        response.setMajor(education.getMajor());
        response.setGpa(education.getGpa());
        response.setStartDate(education.getStartDate());
        response.setEndDate(education.getEndDate());
        response.setUserResponse(userResponse);
        return response;
    }
    public void updateEducationFromDto(EducationRequest request, Education existingEducation) {
        if (request.getInstitution() != null && !request.getInstitution().isEmpty()) {
            existingEducation.setInstitution(request.getInstitution());
        }
        if (request.getDegree() != null && !request.getDegree().isEmpty()) {
            existingEducation.setDegree(request.getDegree());
        }
        if (request.getMajor() != null && !request.getMajor().isEmpty()) {
            existingEducation.setMajor(request.getMajor());
        }
        if (request.getGpa() != null) {
            existingEducation.setGpa(request.getGpa());
        }
        if (request.getStartDate() != null) {
            existingEducation.setStartDate(request.getStartDate());
        }
        if (request.getEndDate() != null) {
            existingEducation.setEndDate(request.getEndDate());
        }
    }
}

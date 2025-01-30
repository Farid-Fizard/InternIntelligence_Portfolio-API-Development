package com.farid.portfolio_api.mapper;

import com.farid.portfolio_api.dto.request.ExperienceRequest;
import com.farid.portfolio_api.dto.response.ExperienceResponse;
import com.farid.portfolio_api.dto.response.UserResponse;
import com.farid.portfolio_api.entity.Experience;
import org.springframework.stereotype.Component;

@Component
public class ExperienceMapper {
    public Experience toEntity(ExperienceRequest request){
        Experience experience= new Experience();
        experience.setCompany(request.getCompany());
        experience.setRole(request.getRole());
        experience.setStartDate(request.getStartDate());
        experience.setEndDate(request.getEndDate());
        return experience;
    }
    public ExperienceResponse toResponse(Experience experience){
            UserResponse userResponse = new UserResponse(
                    experience.getUser().getId(),
                    experience.getUser().getUsername(),
                    experience.getUser().getEmail()
            );

        ExperienceResponse response= new ExperienceResponse();
        response.setId(experience.getId());
        response.setCompany(experience.getCompany());
        response.setRole(experience.getRole());
        response.setStartDate(experience.getStartDate());
        response.setEndDate(experience.getEndDate());
        response.setUserResponse(userResponse);
        return response;
    }

    public void updateExperienceFromDto(ExperienceRequest request, Experience existingExperience) {
        if (request.getCompany() != null && !request.getCompany().isEmpty()) {
            existingExperience.setCompany(request.getCompany());
        }
        if (request.getRole() != null && !request.getRole().isEmpty()) {
            existingExperience.setRole(request.getRole());
        }
        if (request.getStartDate() != null) {
            existingExperience.setStartDate(request.getStartDate());
        }
        if (request.getEndDate() != null) {
            existingExperience.setEndDate(request.getEndDate());
        }
    }
}

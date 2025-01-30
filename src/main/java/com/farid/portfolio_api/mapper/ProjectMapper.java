package com.farid.portfolio_api.mapper;

import com.farid.portfolio_api.dto.request.ProjectRequest;
import com.farid.portfolio_api.dto.request.UserRequest;
import com.farid.portfolio_api.dto.response.ProjectResponse;
import com.farid.portfolio_api.dto.response.UserResponse;
import com.farid.portfolio_api.entity.Project;
import com.farid.portfolio_api.entity.User;
import org.springframework.stereotype.Component;

@Component
public class ProjectMapper {
    public Project toEntity(ProjectRequest request){
        Project project= new Project();
        project.setName(request.getName());
        project.setDescription(request.getDescription());
        project.setTechnologiesUsed(request.getTechnologiesUsed());
        project.setUrl(request.getUrl());
        return project;
    }
    public ProjectResponse toResponse(Project project){
        UserResponse userResponse = new UserResponse(
                project.getUser().getId(),
                project.getUser().getUsername(),
                project.getUser().getEmail()
        );

        ProjectResponse response= new ProjectResponse();
        response.setId(project.getId());
        response.setName(project.getName());
        response.setDescription(project.getDescription());
        response.setTechnologiesUsed(project.getTechnologiesUsed());
        response.setUrl(project.getUrl());
        response.setUserResponse(userResponse);
        return response;
    }

    public void updateProjectFromDto(ProjectRequest request, Project existingProject) {
        if (request.getName() != null && !request.getName().isEmpty()) {
            existingProject.setName(request.getName());
        }
        if (request.getDescription() != null && !request.getDescription().isEmpty()) {
            existingProject.setDescription(request.getDescription());
        }
        if (request.getTechnologiesUsed() != null && !request.getTechnologiesUsed().isEmpty()) {
            existingProject.setTechnologiesUsed(request.getTechnologiesUsed());
        }
        if (request.getUrl() != null && !request.getUrl().isEmpty()) {
            existingProject.setUrl(request.getUrl());
        }
    }
}

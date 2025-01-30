package com.farid.portfolio_api.service;

import com.farid.portfolio_api.dto.request.ProjectRequest;
import com.farid.portfolio_api.dto.response.ProjectResponse;

import java.util.List;

public interface ProjectService {
    ProjectResponse createProject(ProjectRequest request, String token);
    ProjectResponse getProjectById(Long id, String token);
    List<ProjectResponse> getAllProjects(String token);
    ProjectResponse updateProject(Long id, ProjectRequest request, String token);
    void deleteProject(Long id, String token);
}

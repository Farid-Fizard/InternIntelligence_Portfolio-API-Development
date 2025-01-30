package com.farid.portfolio_api.service.serviceImpl;

import com.farid.portfolio_api.dto.request.ProjectRequest;
import com.farid.portfolio_api.dto.response.ProjectResponse;
import com.farid.portfolio_api.entity.Project;
import com.farid.portfolio_api.entity.User;
import com.farid.portfolio_api.mapper.ProjectMapper;
import com.farid.portfolio_api.repository.ProjectRepository;
import com.farid.portfolio_api.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {
    private final ProjectRepository projectRepository;
    private final ProjectMapper projectMapper;
    private final AuthUserService authUserService;
    @Override
    public ProjectResponse createProject(ProjectRequest request, String token) {
        User user=authUserService.getAuthenticatedUser(token);
        Project project = projectMapper.toEntity(request);
        project.setUser(user);
        Project savedProject = projectRepository.save(project);
        return projectMapper.toResponse(savedProject);
    }

    @Override
    public ProjectResponse getProjectById(Long id, String token) {
        User user=authUserService.getAuthenticatedUser(token);
        Project project = projectRepository.findByIdAndUserId(id, user.getId())
                .orElseThrow(() -> new RuntimeException("Project not found or access denied"));
        return projectMapper.toResponse(project);
    }

    @Override
    public List<ProjectResponse> getAllProjects(String token) {
        User user=authUserService.getAuthenticatedUser(token);
        List<Project> projects = projectRepository.findAllByUserId(user.getId());
        return projects.stream()
                .map(projectMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public ProjectResponse updateProject(Long id, ProjectRequest request, String token) {
        User user=authUserService.getAuthenticatedUser(token);
        Project existingProject = projectRepository.findByIdAndUserId(id, user.getId())
                .orElseThrow(() -> new RuntimeException("Project not found or access denied"));
        projectMapper.updateProjectFromDto(request, existingProject);
        Project updatedProject = projectRepository.save(existingProject);
        return projectMapper.toResponse(updatedProject);
    }

    @Override
    public void deleteProject(Long id, String token) {
        User user=authUserService.getAuthenticatedUser(token);
        Project project = projectRepository.findByIdAndUserId(id, user.getId())
                .orElseThrow(() -> new RuntimeException("Project not found or access denied"));
        projectRepository.delete(project);
    }
}

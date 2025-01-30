package com.farid.portfolio_api.controller;

import com.farid.portfolio_api.dto.request.ProjectRequest;
import com.farid.portfolio_api.dto.response.ProjectResponse;
import com.farid.portfolio_api.service.ProjectService;
import com.farid.portfolio_api.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/api/projects")
@RequiredArgsConstructor
public class ProjectController {
    private final ProjectService projectService;
    private final JwtUtil jwtUtil;

    @PostMapping
    public ResponseEntity<ProjectResponse> createProject(@RequestBody ProjectRequest request,
                                                         @RequestHeader("Authorization") String token) {
        ProjectResponse project = projectService.createProject(request, token);
        return ResponseEntity.ok(project);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjectResponse> getProjectById(@PathVariable Long id,
                                                          @RequestHeader("Authorization") String token) {
        ProjectResponse project = projectService.getProjectById(id, token);
        return ResponseEntity.ok(project);
    }

    @GetMapping
    public ResponseEntity<List<ProjectResponse>> getAllProjects(@RequestHeader("Authorization") String token) {
        List<ProjectResponse> projects = projectService.getAllProjects(token);
        return ResponseEntity.ok(projects);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProjectResponse> updateProject(@PathVariable Long id,
                                                         @RequestBody ProjectRequest request,
                                                         @RequestHeader("Authorization") String token) {
        ProjectResponse updatedProject = projectService.updateProject(id, request, token);
        return ResponseEntity.ok(updatedProject);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProject(@PathVariable Long id,
                                              @RequestHeader("Authorization") String token) {
        projectService.deleteProject(id, token);
        return ResponseEntity.noContent().build();
    }
}

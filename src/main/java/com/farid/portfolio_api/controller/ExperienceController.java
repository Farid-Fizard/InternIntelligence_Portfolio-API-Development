package com.farid.portfolio_api.controller;

import com.farid.portfolio_api.dto.request.ExperienceRequest;
import com.farid.portfolio_api.dto.response.ExperienceResponse;
import com.farid.portfolio_api.service.ExperienceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/experiences")
@RequiredArgsConstructor
public class ExperienceController {
    private final ExperienceService experienceService;

    @PostMapping
    public ResponseEntity<ExperienceResponse> createExperience(@RequestBody ExperienceRequest experienceRequest,
                                                               @RequestHeader("Authorization") String token) {
        ExperienceResponse createdExperience = experienceService.createExperience(experienceRequest, token);
        return ResponseEntity.ok(createdExperience);
    }

    @GetMapping
    public ResponseEntity<List<ExperienceResponse>> getAllExperiences(@RequestHeader("Authorization") String token) {
        List<ExperienceResponse> experiences = experienceService.getAllExperiences(token);
        return ResponseEntity.ok(experiences);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExperienceResponse> getExperienceById(@PathVariable Long id,
                                                                @RequestHeader("Authorization") String token) {
        ExperienceResponse experience = experienceService.getExperienceById(id, token);
        return ResponseEntity.ok(experience);
    }


    @PutMapping("/{id}")
    public ResponseEntity<ExperienceResponse> updateExperience(@PathVariable Long id,
                                                               @RequestBody ExperienceRequest experienceRequest,
                                                               @RequestHeader("Authorization") String token) {
        ExperienceResponse updatedExperience = experienceService.updateExperience(id, experienceRequest, token);
        return ResponseEntity.ok(updatedExperience);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExperience(@PathVariable Long id, @RequestHeader("Authorization") String token) {
        experienceService.deleteExperience(id, token);
        return ResponseEntity.noContent().build();
    }
}

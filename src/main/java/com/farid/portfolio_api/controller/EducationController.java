package com.farid.portfolio_api.controller;

import com.farid.portfolio_api.dto.request.EducationRequest;
import com.farid.portfolio_api.dto.response.EducationResponse;
import com.farid.portfolio_api.service.EducationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/educations")
@RequiredArgsConstructor
public class EducationController {
    private final EducationService educationService;


    @PostMapping()
    ResponseEntity<EducationResponse> createProject(@RequestBody EducationRequest educationRequest,
                                                    @RequestHeader("Authorization") String token ){
        EducationResponse createdEducation= educationService.createEducation(educationRequest, token);
        return ResponseEntity.ok(createdEducation);
    }

    @GetMapping()
    ResponseEntity<List<EducationResponse>> getAllProjects(@RequestHeader("Authorization") String token){
        List<EducationResponse> educations=educationService.getAllEducations(token);
        return ResponseEntity.ok(educations);
    }

    @GetMapping("/{id}")
    ResponseEntity<EducationResponse> getProjectById(@PathVariable Long id,
                                                     @RequestHeader("Authorization") String token){
        EducationResponse education= educationService.getEducationById(id, token);
        return ResponseEntity.ok(education);
    }

    @PutMapping("/{id}")
    ResponseEntity<EducationResponse> updateProject(@PathVariable Long id,
                                                    @RequestBody EducationRequest educationRequest,
                                                    @RequestHeader("Authorization") String token){
        EducationResponse updatedEducation= educationService.updateEducation(id,educationRequest,token);
        return ResponseEntity.ok(updatedEducation);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<EducationResponse> deleteProject(@PathVariable Long id,
                                                    @RequestHeader("Authorization") String token){
        educationService.deleteEducation(id,token);
       return ResponseEntity.noContent().build();
    }
}

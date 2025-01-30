package com.farid.portfolio_api.controller;

import com.farid.portfolio_api.dto.request.SkillRequest;
import com.farid.portfolio_api.dto.response.SkillResponse;
import com.farid.portfolio_api.service.SkillService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/skills")
public class SkillController {
    private final SkillService skillService;

    public SkillController(SkillService skillService) {
        this.skillService = skillService;
    }

    @PostMapping()
    public ResponseEntity<SkillResponse> createSkill(@RequestBody SkillRequest skillRequest,
                                                     @RequestHeader("Authorization") String token){
        SkillResponse createdSkill = skillService.createSkill(skillRequest,token);
        return ResponseEntity.ok(createdSkill);
    }

    @GetMapping()
    public  ResponseEntity<List<SkillResponse>> getAllSkills(@RequestHeader("Authorization") String token){
        List<SkillResponse> skills= skillService.getAllSkills(token);
        return ResponseEntity.ok(skills);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SkillResponse> createSkill(@PathVariable Long id,
                                                     @RequestHeader("Authorization") String token){
        SkillResponse skill = skillService.getSkillById(id,token);
        return ResponseEntity.ok(skill);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SkillResponse> updateSkill(@PathVariable Long id,
                                                     @RequestBody SkillRequest skillRequest,
                                                     @RequestHeader("Authorization") String token){
        SkillResponse updatedSkill= skillService.updateSkill(id,skillRequest,token);
        return ResponseEntity.ok(updatedSkill);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SkillResponse> deleteSkill(@PathVariable Long id,
                                                     @RequestHeader("Authorization") String token){
        skillService.deleteSkill(id,token);
        return ResponseEntity.noContent().build();
    }
}

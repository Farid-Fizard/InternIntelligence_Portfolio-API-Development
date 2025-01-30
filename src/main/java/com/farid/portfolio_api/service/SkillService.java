package com.farid.portfolio_api.service;

import com.farid.portfolio_api.dto.request.SkillRequest;
import com.farid.portfolio_api.dto.response.SkillResponse;

import java.util.List;

public interface SkillService {
    SkillResponse createSkill(SkillRequest request,String token);
    SkillResponse getSkillById(Long id,String token);
    List <SkillResponse> getAllSkills(String token);
    SkillResponse updateSkill(Long id,SkillRequest request,String token);
    void deleteSkill(Long id,String token);
}

package com.farid.portfolio_api.mapper;

import com.farid.portfolio_api.dto.request.ProjectRequest;
import com.farid.portfolio_api.dto.request.SkillRequest;
import com.farid.portfolio_api.dto.request.UserRequest;
import com.farid.portfolio_api.dto.response.SkillResponse;
import com.farid.portfolio_api.dto.response.UserResponse;
import com.farid.portfolio_api.entity.Project;
import com.farid.portfolio_api.entity.Skill;
import com.farid.portfolio_api.entity.User;
import org.springframework.stereotype.Component;

@Component
public class SkillMapper {

    public Skill toEntity(SkillRequest request){
        Skill skill= new Skill();
        skill.setName(request.getName());
        skill.setProficiencyLevel(request.getProficiencyLevel());
        return skill;
    }

    public SkillResponse toResponse(Skill skill){
        UserResponse userResponse = new UserResponse(
                skill.getUser().getId(),
                skill.getUser().getUsername(),
                skill.getUser().getEmail()
        );
        SkillResponse response= new SkillResponse();
        response.setId(skill.getId());
        response.setName(skill.getName());
        response.setProficiencyLevel(skill.getProficiencyLevel());
        response.setUserResponse(userResponse);
        return response;
    }

    public void updateSkillFromDto(SkillRequest request, Skill existingSkill) {
        if (request.getName() != null && !request.getName().isEmpty()) {
            existingSkill.setName(request.getName());
        }
        if (request.getProficiencyLevel() != null && !request.getProficiencyLevel().isEmpty()) {
            existingSkill.setProficiencyLevel(request.getProficiencyLevel());
        }
    }
}

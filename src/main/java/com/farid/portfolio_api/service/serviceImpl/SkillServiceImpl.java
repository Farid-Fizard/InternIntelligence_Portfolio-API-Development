package com.farid.portfolio_api.service.serviceImpl;

import com.farid.portfolio_api.dto.request.SkillRequest;
import com.farid.portfolio_api.dto.response.SkillResponse;
import com.farid.portfolio_api.entity.Skill;
import com.farid.portfolio_api.entity.User;
import com.farid.portfolio_api.mapper.SkillMapper;
import com.farid.portfolio_api.repository.SkillRepository;
import com.farid.portfolio_api.service.SkillService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SkillServiceImpl implements SkillService {

    private final SkillRepository skillRepository;
    private final SkillMapper skillMapper;
    private final AuthUserService authUserService;

    @Override
    public SkillResponse createSkill(SkillRequest request, String token) {
        User user=authUserService.getAuthenticatedUser(token);
        Skill skill= skillMapper.toEntity(request);
        skill.setUser(user);
        Skill savedSkill=skillRepository.save(skill);
        return skillMapper.toResponse(savedSkill);
    }

    @Override
    public SkillResponse getSkillById(Long id,String token) {
        User user=authUserService.getAuthenticatedUser(token);
        Skill skill= skillRepository.findByIdAndUserId(id, user.getId())
                .orElseThrow(()-> new RuntimeException("Skill not found with id: " + id));
        return skillMapper.toResponse(skill);

    }

    @Override
    public List<SkillResponse> getAllSkills(String token) {
        User user=authUserService.getAuthenticatedUser(token);
        List<Skill> skills= skillRepository.findAllByUserId(user.getId());
        return skills.stream()
                .map(skillMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public SkillResponse updateSkill(Long id, SkillRequest request,String token) {
        User user=authUserService.getAuthenticatedUser(token);
        Skill existingSkill= skillRepository.findByIdAndUserId(id, user.getId())
                .orElseThrow(()-> new RuntimeException("Skill not found with id: " + id));
        skillMapper.updateSkillFromDto(request,existingSkill);
        Skill updatedSkill=skillRepository.save(existingSkill);
        return skillMapper.toResponse(updatedSkill);
    }

    @Override
    public void deleteSkill(Long id,String token) {
        User user=authUserService.getAuthenticatedUser(token);
        Skill skill= skillRepository.findByIdAndUserId(id, user.getId())
                .orElseThrow(()-> new RuntimeException("Skill not found with id: " + id));
        skillRepository.delete(skill);
    }
}

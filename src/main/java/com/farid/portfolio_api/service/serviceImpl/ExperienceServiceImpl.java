package com.farid.portfolio_api.service.serviceImpl;

import com.farid.portfolio_api.dto.request.ExperienceRequest;
import com.farid.portfolio_api.dto.response.ExperienceResponse;
import com.farid.portfolio_api.entity.Experience;
import com.farid.portfolio_api.entity.User;
import com.farid.portfolio_api.mapper.ExperienceMapper;
import com.farid.portfolio_api.repository.ExperienceRepository;
import com.farid.portfolio_api.repository.UserRepository;
import com.farid.portfolio_api.service.ExperienceService;
import com.farid.portfolio_api.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ExperienceServiceImpl implements ExperienceService {
    private final ExperienceRepository experienceRepository;
    private final ExperienceMapper experienceMapper;
    private final AuthUserService authUserService;


    @Override
    public ExperienceResponse createExperience(ExperienceRequest request, String token) {
        User user=authUserService.getAuthenticatedUser(token);
        Experience experience = experienceMapper.toEntity(request);
        experience.setUser(user);
        Experience savedExperience = experienceRepository.save(experience);
        return experienceMapper.toResponse(savedExperience);
    }

    @Override
    public ExperienceResponse getExperienceById(Long id, String token) {
        User user=authUserService.getAuthenticatedUser(token);
        Experience experience = experienceRepository.findByIdAndUserId(id, user.getId())
                .orElseThrow(() -> new RuntimeException("Experience not found or access denied"));
        return experienceMapper.toResponse(experience);
    }

    @Override
    public List<ExperienceResponse> getAllExperiences(String token) {
        User user=authUserService.getAuthenticatedUser(token);
        List<Experience> experiences = experienceRepository.findAllByUserId(user.getId());
        return experiences.stream()
                .map(experienceMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public ExperienceResponse updateExperience(Long id, ExperienceRequest request, String token) {
        User user=authUserService.getAuthenticatedUser(token);
        Experience existingExperience = experienceRepository.findByIdAndUserId(id, user.getId())
                .orElseThrow(() -> new RuntimeException("Experience not found or access denied"));
        experienceMapper.updateExperienceFromDto(request, existingExperience);
        Experience updatedExperience = experienceRepository.save(existingExperience);
        return experienceMapper.toResponse(updatedExperience);
    }

    @Override
    public void deleteExperience(Long id, String token) {
        User user=authUserService.getAuthenticatedUser(token);
        Experience experience = experienceRepository.findByIdAndUserId(id, user.getId())
                .orElseThrow(() -> new RuntimeException("Experience not found or access denied"));
        experienceRepository.delete(experience);
    }
}

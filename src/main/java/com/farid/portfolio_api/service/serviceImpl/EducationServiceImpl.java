package com.farid.portfolio_api.service.serviceImpl;

import com.farid.portfolio_api.dto.request.EducationRequest;
import com.farid.portfolio_api.dto.response.EducationResponse;
import com.farid.portfolio_api.entity.Education;
import com.farid.portfolio_api.entity.User;
import com.farid.portfolio_api.mapper.EducationMapper;
import com.farid.portfolio_api.repository.EducationRepository;
import com.farid.portfolio_api.repository.UserRepository;
import com.farid.portfolio_api.service.EducationService;
import com.farid.portfolio_api.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EducationServiceImpl implements EducationService {
    private final EducationRepository educationRepository;
    private final EducationMapper educationMapper;
    private final AuthUserService authUserService;


    @Override
    public EducationResponse createEducation(EducationRequest request, String token) {
        User user=authUserService.getAuthenticatedUser(token);
        Education education= educationMapper.toEntity(request);
        education.setUser(user);
        Education savedEducation= educationRepository.save(education);
        return educationMapper.toResponse(savedEducation);
    }

    @Override
    public EducationResponse getEducationById(Long id, String token) {
        User user=authUserService.getAuthenticatedUser(token);
        Education education= educationRepository.findByIdAndUserId(id, user.getId())
                .orElseThrow(()-> new RuntimeException("Education not found with id: " + id));
        return educationMapper.toResponse(education);
    }

    @Override
    public List<EducationResponse> getAllEducations(String token) {
        User user=authUserService.getAuthenticatedUser(token);
        List<Education> educationList= educationRepository.findAllByUserId(user.getId());
        return educationList.stream()
                .map(educationMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public EducationResponse updateEducation(Long id, EducationRequest request,String token) {
        User user=authUserService.getAuthenticatedUser(token);
        Education existingEducation= educationRepository.findByIdAndUserId(id, user.getId())
                .orElseThrow(()-> new RuntimeException("Education not found with id: " + id));
        educationMapper.updateEducationFromDto(request,existingEducation);
        Education updatedEducation= educationRepository.save(existingEducation);
        return educationMapper.toResponse(updatedEducation);
    }

    @Override
    public void deleteEducation(Long id, String token) {
        User user=authUserService.getAuthenticatedUser(token);
        Education education= educationRepository.findByIdAndUserId(id, user.getId())
                .orElseThrow(() -> new RuntimeException("Education not found or access denied"));
        educationRepository.delete(education);
    }
}

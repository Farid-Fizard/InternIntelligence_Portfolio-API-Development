package com.farid.portfolio_api.repository;

import com.farid.portfolio_api.entity.Education;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EducationRepository extends JpaRepository<Education,Long> {
    List<Education> findAllByUserId(Long userId);
    Optional<Education> findByIdAndUserId(Long id, Long userId);
}

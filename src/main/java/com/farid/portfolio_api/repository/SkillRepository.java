package com.farid.portfolio_api.repository;

import com.farid.portfolio_api.entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SkillRepository extends JpaRepository<Skill,Long> {
    List<Skill> findAllByUserId(Long userId);
    Optional<Skill> findByIdAndUserId(Long id, Long userId);
}

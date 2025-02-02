package com.farid.portfolio_api.repository;

import com.farid.portfolio_api.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProjectRepository extends JpaRepository<Project,Long> {
    List<Project> findAllByUserId(Long userId);
    Optional<Project> findByIdAndUserId(Long id, Long userId);
}

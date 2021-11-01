package com.healthcare.repository;

import com.healthcare.DTO.CoachDTO;
import com.healthcare.entity.CoachEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface CoachRepository extends JpaRepository<CoachEntity,String> {
    public Optional<CoachEntity> findByCoachId(String coachId);
}

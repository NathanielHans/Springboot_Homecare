package com.homecare.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.homecare.entities.Team;

public interface TeamRepository extends JpaRepository<Team, Long>{
    
}

package com.homecare.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.homecare.entities.Care;

public interface CareRepository extends JpaRepository<Care, Long>{
    
}

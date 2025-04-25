package com.homecare.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.homecare.entities.Review;

public interface ReviewRepository extends JpaRepository<Review, Long>{
    
}

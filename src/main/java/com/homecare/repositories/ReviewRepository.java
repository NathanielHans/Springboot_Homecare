package com.homecare.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.homecare.entities.Review;
import com.homecare.entities.User;


public interface ReviewRepository extends JpaRepository<Review, Long>{
    List<Review> findByUser(User user);
    
}

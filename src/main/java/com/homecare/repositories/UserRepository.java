package com.homecare.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.homecare.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
    
}

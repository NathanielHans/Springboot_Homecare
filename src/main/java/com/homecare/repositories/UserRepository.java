package com.homecare.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.homecare.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
    Optional<User> findByUsername(String username);

    boolean existsByUsername(String username);
    boolean existsByPhone(String phone);
}

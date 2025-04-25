package com.homecare.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.homecare.entities.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    
}

package com.homecare.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.homecare.entities.Booking;
import com.homecare.entities.User;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByUser(User user);

    List<Booking> fin
}

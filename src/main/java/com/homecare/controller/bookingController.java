package com.homecare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.homecare.dto.Booking.bookingRequestDto;
import com.homecare.dto.Booking.bookingResponseDto;
import com.homecare.services.BookingServices;

@RestController
@RequestMapping("/api/bookings")
public class bookingController {
    @Autowired private BookingServices bookingServices;

    @PostMapping
    public ResponseEntity<bookingResponseDto> create(@RequestBody bookingRequestDto request) {
        return ResponseEntity.ok(bookingServices.addBooking(request));
    }

    @GetMapping
    public ResponseEntity<List<bookingResponseDto>> getAll() {
        return ResponseEntity.ok(bookingServices.getAllBookings());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        String message = bookingServices.deleteBooking(id);
        return ResponseEntity.ok(message);
    }
    
}

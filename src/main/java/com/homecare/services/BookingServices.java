package com.homecare.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homecare.dto.Booking.bookingRequestDto;
import com.homecare.dto.Booking.bookingResponseDto;
import com.homecare.entities.Booking;
import com.homecare.entities.Care;
import com.homecare.entities.User;
import com.homecare.repositories.BookingRepository;
import com.homecare.repositories.CareRepository;
import com.homecare.repositories.UserRepository;

@Service
public class BookingServices {
    @Autowired private BookingRepository bookingRepository;
    @Autowired private UserRepository userRepository;
    @Autowired private CareRepository careRepository;

    public bookingResponseDto addBooking (bookingRequestDto request){
        User user = userRepository.findById(request.getUserId())
            .orElseThrow(() -> new RuntimeException("User tidak ditemukan."));
        
        Care care = careRepository.findById(request.getCareId())
            .orElseThrow(() -> new RuntimeException("Care tidak ditemukan."));
        
        Booking booking = new Booking();
        booking.setBookingDate(request.getBookingDate());
        booking.setCare(care);
        booking.setUser(user);
        
        Booking itemAdded = bookingRepository.save(booking);
        return new bookingResponseDto(itemAdded.getId(), itemAdded.getBookingDate(), user.getUsername(), care.getName());
    }

    public List<bookingResponseDto> getAllBookings() {
        List<Booking> bookingList = bookingRepository.findAll();

        return bookingList.stream()
            .map(booking -> new bookingResponseDto(booking.getId(), booking.getBookingDate(), booking.getUser().getUsername(), booking.getCare().getName()))
            .collect(Collectors.toList());
    }

    public String deleteBooking(Long id) {
        bookingRepository.deleteById(id);
        return "Booking ID-"+id+" berhasil dihapus.";
    }
}

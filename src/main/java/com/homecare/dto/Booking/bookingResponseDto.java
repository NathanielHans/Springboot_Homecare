package com.homecare.dto.Booking;


public class bookingResponseDto {
    private Long id;
    private String bookingDate;
    private String username;
    private String careName;

    public bookingResponseDto(Long id, String bookingDate, String username, String careName) {
        this.bookingDate = bookingDate;
        this.careName = careName;
        this.id = id;
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCareName() {
        return careName;
    }

    public void setCareName(String careName) {
        this.careName = careName;
    }
    
    
}

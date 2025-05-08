package com.homecare.dto.Booking;


public class bookingRequestDto {
    private String bookingDate;
    private Long userId;
    private Long careId;

    public bookingRequestDto(String bookingDate, Long careId, Long userId) {
        this.bookingDate = bookingDate;
        this.careId = careId;
        this.userId = userId;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getCareId() {
        return careId;
    }

    public void setCareId(Long careId) {
        this.careId = careId;
    }
    
    
    
}

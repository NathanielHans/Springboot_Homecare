package com.homecare.dto.Review;

public class reviewRequestDto {
    private String review;

    public reviewRequestDto(String review) {
        this.review = review;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    
}

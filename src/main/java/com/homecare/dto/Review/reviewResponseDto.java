package com.homecare.dto.Review;

import com.homecare.entities.User;

public class reviewResponseDto {
    private Long reviewId;
    private String review;
    private User user;

    public reviewResponseDto( Long reviewId, String review, User user) {
        this.review = review;
        this.reviewId = reviewId;
        this.user = user;
    }

    public Long getReviewId() {
        return reviewId;
    }

    public void setReviewId(Long reviewId) {
        this.reviewId = reviewId;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


}

package com.homecare.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homecare.dto.Review.reviewRequestDto;
import com.homecare.dto.Review.reviewResponseDto;
import com.homecare.entities.Review;
import com.homecare.entities.User;
import com.homecare.repositories.ReviewRepository;
import com.homecare.repositories.UserRepository;

@Service
public class ReviewServices {
    @Autowired private ReviewRepository reviewRepository;
    @Autowired private UserRepository userRepository;

    public List<reviewResponseDto> getAllReview(){
        List<Review> reviewList = reviewRepository.findAll();
        return reviewList.stream()
            .map(review -> new reviewResponseDto(review.getReviewId(), review.getReview(), review.getUser()))
            .collect(Collectors.toList());
    }
    
    public reviewResponseDto addReview (reviewRequestDto request, String username){
        User user = userRepository.findByUsername(username).orElseThrow();
        Review review = new Review();
        review.setReview(request.getReview());
        review.setUser(user);

        Review itemAdded = reviewRepository.save(review);
        return new reviewResponseDto(itemAdded.getReviewId(), itemAdded.getReview(), itemAdded.getUser()); 
    }

    public reviewResponseDto updateReview (Long id, reviewRequestDto request){
        Review review = reviewRepository.findById(id)
            .orElseThrow(()-> new RuntimeException("review dengan ID-"+id+" tidak ditemukan."));
        
        review.setReview(request.getReview());

        Review itemAdded = reviewRepository.save(review);
        return new reviewResponseDto(itemAdded.getReviewId(), itemAdded.getReview(), itemAdded.getUser()); 
    }

    public String deleteReview(Long id){
        Review review = reviewRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Review dengan ID-"+id+" tidak ditemukan."));
        
        reviewRepository.delete(review);
        return "Review dengan ID-"+id+" berhasil dihapus.";
    }
}

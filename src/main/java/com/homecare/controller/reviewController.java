package com.homecare.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.homecare.dto.Review.reviewRequestDto;
import com.homecare.dto.Review.reviewResponseDto;
import com.homecare.services.ReviewServices;




@RestController
@RequestMapping("/api/reviews")
public class reviewController {
    @Autowired private ReviewServices reviewServices;

    @GetMapping
    public List<reviewResponseDto> getAllReviews () {
        return reviewServices.getAllReview();
    }

    @PostMapping("path")
    public reviewResponseDto addReviews(@RequestBody reviewRequestDto request, Principal principal) {
        return reviewServices.addReview(request, principal.getName());
    }

    @PutMapping("/{id}")
    public ResponseEntity<reviewResponseDto> updateReviews(@PathVariable Long id, @RequestBody reviewRequestDto request) {        
        reviewResponseDto updateReviews = reviewServices.updateReview(id, request);
        return ResponseEntity.ok(updateReviews);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteReviews(@PathVariable Long id){
        String message = reviewServices.deleteReview(id);
        return ResponseEntity.ok(message);
    }
    
}

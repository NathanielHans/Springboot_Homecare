package com.homecare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.homecare.dto.Auth.authResponseDto;
import com.homecare.dto.Auth.loginRequestDto;
import com.homecare.dto.Auth.registerRequestDto;
import com.homecare.services.AuthServices;


@RestController
@RequestMapping("/api/auth")
public class authController {
    @Autowired private AuthServices authServices;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody registerRequestDto request) {
        String message = authServices.register(request);
        return ResponseEntity.ok(message);
    }
    @PostMapping("/login")
    public authResponseDto login(@RequestBody loginRequestDto request) {
        return authServices.login(request);
    }
    
    
}

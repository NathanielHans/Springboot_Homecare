package com.homecare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.homecare.dto.Auth.authResponseDto;
import com.homecare.dto.Auth.loginRequestDto;
import com.homecare.dto.Auth.registerRequestDto;
import com.homecare.sevices.AuthServices;


@RestController
@RequestMapping("/api/auth")
public class authController {
    @Autowired private AuthServices authServices;

    @PostMapping("/register")
    public authResponseDto register(@RequestBody registerRequestDto request) {
        return authServices.register(request);
    }
    @PostMapping("/login")
    public authResponseDto login(@RequestBody loginRequestDto request) {
        //TODO: process POST request
        
        return authServices.login(request);
    }
    
    
}

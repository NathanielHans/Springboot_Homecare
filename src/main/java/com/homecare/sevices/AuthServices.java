package com.homecare.sevices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.homecare.dto.Auth.authResponseDto;
import com.homecare.dto.Auth.loginRequestDto;
import com.homecare.dto.Auth.registerRequestDto;
import com.homecare.entities.User;
import com.homecare.repositories.UserRepository;

@Service
public class AuthServices {
    @Autowired private UserRepository userRepository;
    @Autowired private PasswordEncoder encoder ;
    @Autowired private JwtServices jwtServices;
    @Autowired private CustomUserDetailsServices userDetailsServices;

    public authResponseDto register(registerRequestDto request){
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(encoder.encode(request.getPassword()));
        user.setPhone(request.getPhone());
        user.setRole("Role_User");

        userRepository.save(user);
        UserDetails userDetail = userDetailsServices.loadUserByUsername(user.getUsername());
        String token = jwtServices.generateToken(userDetail); 
        return new authResponseDto(token);
    }

    public authResponseDto login(loginRequestDto request){
        UserDetails userDetails = userDetailsServices.loadUserByUsername(request.getUsername());
        if (!encoder.matches(request.password, userDetails.getPassword())) {
            throw new RuntimeException("Password salah");
        }
        String token = jwtServices.generateToken(userDetails);
        return new authResponseDto(token);
    }

}

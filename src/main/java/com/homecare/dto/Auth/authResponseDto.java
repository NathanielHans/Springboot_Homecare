package com.homecare.dto.Auth;

public class authResponseDto {
    public String token;

    public authResponseDto(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}

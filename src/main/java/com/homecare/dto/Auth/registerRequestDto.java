package com.homecare.dto.Auth;

public class registerRequestDto {
    public String username;
    public String password;
    public String phone;

    public registerRequestDto(String password, String phone, String username) {
        this.password = password;
        this.phone = phone;
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


}

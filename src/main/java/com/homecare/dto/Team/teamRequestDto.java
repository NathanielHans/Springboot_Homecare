package com.homecare.dto.Team;

public class teamRequestDto {
    private String name;
    private String specialization;
    private String phone;

    public teamRequestDto(String name, String phone, String specialization) {
        this.name = name;
        this.phone = phone;
        this.specialization = specialization;
    }
   
    public teamRequestDto() {
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSpecialization() {
        return specialization;
    }
    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    
    
}

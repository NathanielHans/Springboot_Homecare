package com.homecare.dto.Team;

public class teamResponseDto {
    private Long teamID;
    private String name;
    private String specialization;
    private String phone;

    public teamResponseDto(Long teamID, String name, String specialization, String phone) {
        this.teamID = teamID;
        this.name = name;
        this.specialization = specialization;
        this.phone = phone;
    }

    public teamResponseDto() {
    }

    public Long getTeamID() {
        return teamID;
    }

    public void setTeamID(Long teamID) {
        this.teamID = teamID;
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

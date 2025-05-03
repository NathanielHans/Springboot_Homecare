package com.homecare.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Team implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long teamID;

    @Column(nullable=false, length=200)
    @NotBlank(message = "Please provide Team's name!")
    private String name;

    @Column(nullable=false, length=200)
    @NotBlank(message = "Please provide Team's specialization!")
    private String specialization;

    @Column(nullable=false, length=200)
    @NotBlank(message = "Please provide Care's phone!")
    private String phone;

    public Team(Long teamID, @NotBlank(message = "Please provide Team's name!") String name,
            @NotBlank(message = "Please provide Team's specialization!") String specialization,
            @NotBlank(message = "Please provide Care's phone!") String phone) {
        this.teamID = teamID;
        this.name = name;
        this.specialization = specialization;
        this.phone = phone;
    }

    public Team() {
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

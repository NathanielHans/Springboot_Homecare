package com.homecare.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.homecare.dto.Team.teamRequestDto;
import com.homecare.dto.Team.teamResponseDto;
import com.homecare.services.TeamServices;



@RestController
@RequestMapping("/api/team")
public class teamController {
    private final TeamServices teamServices;

    public teamController(TeamServices teamServices) {
        this.teamServices = teamServices;
    }
    
    @GetMapping
    public List<teamResponseDto> getTeam() {
        return teamServices.getAllTeam();
    }
    
    @PostMapping
    public teamResponseDto addTeam(@RequestBody teamRequestDto request) {
        return teamServices.addTeam(request);
    }

    @PutMapping("/{id}")
    public ResponseEntity<teamResponseDto> editTeam(@PathVariable Long id, @RequestBody teamRequestDto request) {
        teamResponseDto itemUpdated = teamServices.editTeam(id, request);       
        return ResponseEntity.ok(itemUpdated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTeam(@PathVariable Long id){
        String message = teamServices.deleteTeam(id);
        return ResponseEntity.ok(message);
    }
    
}

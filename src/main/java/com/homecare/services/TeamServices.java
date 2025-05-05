package com.homecare.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.homecare.dto.Team.teamRequestDto;
import com.homecare.dto.Team.teamResponseDto;
import com.homecare.entities.Team;
import com.homecare.repositories.TeamRepository;

@Service
public class TeamServices {
    private final TeamRepository teamRepository;

    public TeamServices(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public List<teamResponseDto> getAllTeam(){
        List<Team> teamList = teamRepository.findAll();
        return teamList.stream()
            .map(team -> new teamResponseDto(team.getTeamID(), team.getName(), team.getSpecialization(), team.getPhone()))
            .collect(Collectors.toList());
    }

    public teamResponseDto addTeam (teamRequestDto request){
        Team team = new Team();
        team.setName(request.getName());
        team.setSpecialization(request.getSpecialization());
        team.setPhone(request.getPhone());

        Team itemSaved = teamRepository.save(team);
        return new teamResponseDto(itemSaved.getTeamID(), itemSaved.getName(), itemSaved.getSpecialization(), itemSaved.getPhone());
    }

    public  teamResponseDto editTeam (Long id, teamRequestDto request){
        Team team = teamRepository.findById(id)
            .orElseThrow(()-> new RuntimeException("Team dengan ID-"+id+" tidak ditemukan."));

        team.setName(request.getName());
        team.setSpecialization(request.getSpecialization());
        team.setPhone(request.getPhone());

        Team updated = teamRepository.save(team);
        return new teamResponseDto(updated.getTeamID(), updated.getName(), updated.getSpecialization(), updated.getPhone());
    }

    public String deleteTeam (Long id){
        Team team = teamRepository.findById(id)
            .orElseThrow(()-> new RuntimeException("Team dengan ID-"+id+" tidak ditemukan."));
        
        teamRepository.delete(team);
        return "Team dengan ID-"+id+" telah dihapus";
    }





    
}

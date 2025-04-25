package com.homecare.sevices;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.homecare.dto.Care.careRequestDto;
import com.homecare.dto.Care.careResponseDto;
import com.homecare.entities.Care;
import com.homecare.repositories.CareRepository;

@Service
public class CareServices {
    private final CareRepository careRepository;

    
    public CareServices(CareRepository careRepository) {
        this.careRepository = careRepository;
    }

    public List<careResponseDto> getAllCare(){
        List<Care> careList = careRepository.findAll();
        return  careList.stream()
            .map(care -> new careResponseDto(care.getCareId(),care.getDescription(), care.getName(), care.getPrice()))
            .collect(Collectors.toList());
    }

    public careResponseDto addCare (careRequestDto request){
        Care care = new Care();
        care.setDescription(request.getDescription());
        care.setName(request.getName());
        care.setPrice(request.getPrice());

        // Care itemSaved = new Care();
        Care itemSaved = careRepository.save(care);
        return new careResponseDto(itemSaved.getCareId(), itemSaved.getDescription(),itemSaved.getName(), itemSaved.getPrice());

    }
}

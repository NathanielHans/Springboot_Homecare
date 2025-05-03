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

import com.homecare.dto.Care.careRequestDto;
import com.homecare.dto.Care.careResponseDto;
import com.homecare.sevices.CareServices;

import jakarta.validation.Valid;



@RestController
@RequestMapping("/api/care")
public class careController {
    private final CareServices careServices;

    public careController(CareServices careServices) {
        this.careServices = careServices;
    }

    @GetMapping
    public List<careResponseDto> getCare() {
        return careServices.getAllCare();
    }
    
    @PostMapping
    public careResponseDto addCare(@RequestBody careRequestDto request ){
        return careServices.addCare(request);
    }

    @PutMapping("/{id}")
    public ResponseEntity<careResponseDto> updateCare(@PathVariable Long id, @RequestBody @Valid careRequestDto request) {
        careResponseDto updateCare = careServices.updateCare(id, request);
        return ResponseEntity.ok(updateCare);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCare (@PathVariable Long id){
        String message = careServices.deleteCare(id);
        return ResponseEntity.ok(message);
        
    }
}

package com.homecare.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.homecare.dto.Care.careRequestDto;
import com.homecare.dto.Care.careResponseDto;
import com.homecare.sevices.CareServices;


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
}

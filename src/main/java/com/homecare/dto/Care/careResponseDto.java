package com.homecare.dto.Care;

import java.math.BigDecimal;


public class careResponseDto {
    private Long careId;
    private String name;
    private String description;
    private BigDecimal price;

    public careResponseDto(Long careId, String description, String name, BigDecimal price) {
        this.careId = careId;
        this.description = description;
        this.name = name;
        this.price = price;
    }

    public Long getCareId() {
        return careId;
    }

    public void setCareId(Long careId) {
        this.careId = careId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    

}

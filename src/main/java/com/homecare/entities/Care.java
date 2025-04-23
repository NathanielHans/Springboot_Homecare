package com.homecare.entities;

import java.io.Serializable;
import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
// import lombok.AllArgsConstructor;

@Entity
public class Care implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long careId;

    @Column(nullable=false, length=200)
    @NotBlank(message = "Please provide Care's name!")
    private String name;

    @Column(nullable=false, length=500)
    @NotBlank(message = "Please provide Care's description!")
    private String description;
    
    @Column(nullable=false)
    @NotBlank(message = "Please provide Care's price!")
    private BigDecimal price;

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

    public Care() {
    }

    public Care(Long careId, @NotBlank(message = "Please provide Care's name!") String name,
            @NotBlank(message = "Please provide Care's description!") String description,
            @NotBlank(message = "Please provide Care's price!") BigDecimal price) {
        this.careId = careId;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    
}

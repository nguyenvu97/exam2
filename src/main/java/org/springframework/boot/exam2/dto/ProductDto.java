package org.springframework.boot.exam2.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.exam2.model.Enum.ProductType;
import org.springframework.boot.exam2.model.Manufacturer;

import java.math.BigDecimal;

@Setter
@Getter
public class ProductDto {
    private Long id;
    private String productName;
    private ProductType productType;
    private String description;
    private BigDecimal price;
    private double discount;
    public String name;
    public String origin;
    public String description_Manufacturer;
}

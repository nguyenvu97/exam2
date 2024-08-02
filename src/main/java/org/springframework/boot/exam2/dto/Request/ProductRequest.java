package org.springframework.boot.exam2.dto.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.boot.exam2.model.Enum.ProductType;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequest {
    private long id;

    private String productName;

    private String description;

    private BigDecimal price;

    private double discount;
}

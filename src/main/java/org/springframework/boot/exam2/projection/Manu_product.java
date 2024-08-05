package org.springframework.boot.exam2.projection;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import org.springframework.boot.exam2.model.Enum.ProductType;
import org.springframework.boot.exam2.model.Product;

import java.math.BigDecimal;
import java.util.List;

public interface Manu_product {
    Long getManuId();
    String getManuName();
    String getManuOrigin();
    String getManuDescription();
    int getProducts();
    List<Product> getProductList();


}

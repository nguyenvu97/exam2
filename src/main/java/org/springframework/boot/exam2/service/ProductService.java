package org.springframework.boot.exam2.service;

import org.springframework.boot.exam2.dto.ProductDto;
import org.springframework.boot.exam2.dto.Request.ProductRequest;
import org.springframework.boot.exam2.model.Product;
import org.springframework.boot.exam2.projection.Manu_product;

import java.util.List;

public interface ProductService {
    String add(List<Product> products, long manufacturerId );

    int countProduct(long manufacturerId);

    ProductDto update( ProductRequest productRequest);

    String delete(long ProductId);

   List<ProductDto>  searchProduct(String  productName);

    List<Manu_product>  searchProduct1(String productName);
}

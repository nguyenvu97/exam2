package org.springframework.boot.exam2.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.exam2.dto.ProductDto;
import org.springframework.boot.exam2.dto.Request.ProductRequest;
import org.springframework.boot.exam2.exception.NotFound;
import org.springframework.boot.exam2.mapper.ProductMapper;
import org.springframework.boot.exam2.model.Enum.ProductType;
import org.springframework.boot.exam2.model.Manufacturer;
import org.springframework.boot.exam2.model.Product;
import org.springframework.boot.exam2.repository.ManufacturerDao;
import org.springframework.boot.exam2.repository.ProductDao;
import org.springframework.boot.exam2.service.ProductService;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class ProductServiceImpl implements ProductService {
    public final ProductDao productDao;
    private final ManufacturerDao manufacturerDao;
    public final ProductMapper productMapper;

    @Override
    public String add(List<Product> products, long manufacturerId) {
        if (manufacturerId <=0){
            throw new NotFound("manufacturer id can't be less than 0");
        }
       Manufacturer manufacturer = manufacturerDao.findById(manufacturerId).orElseThrow(() -> new NotFound("manufacturer not found"));

        List<Product> products1 = new ArrayList<>();
        for (Product product : products) {
            product.setManufacturer(manufacturer);
            product.setProductName(product.getProductName());
            product.setProductType(ProductType.OPEN);
            product.setDescription(product.getDescription());
            product.setPrice(product.getPrice());
            product.setDiscount(product.getDiscount());
            products1.add(product);
        }
        productDao.saveAll(products1);
        return "Ok";
    }

    @Override
    public int countProduct(long manufacturerId) {
        int count = productDao.countManufacturer(manufacturerId);
        return count;
    }

    @Override
    public String delete(long ProductId) {

        Product product = productDao.findById(ProductId).orElseThrow(() -> new NotFound("Product not found"));
        Optional<Manufacturer>  manufacturer = manufacturerDao.findById(product.getManufacturer().getId());
        if (manufacturer.isPresent()) {
            productDao.deleteById(ProductId);
            return "Delete Ok";
        }
        product.setProductType(ProductType.OFF);
        productDao.save(product);
        return "ok";

    }

    @Override
    public List<ProductDto> searchProduct(String productName) {
        List<Product> products = productDao.findBySearch(productName);
        return productMapper.toListDto(products);
    }

    @Override
    @Async
    public ProductDto update( ProductRequest productRequest) {
        Product product = productDao.findById(productRequest.getId()).orElseThrow(() -> new NotFound("Product not found"));
        Optional<Manufacturer>  manufacturer = manufacturerDao.findById(product.getManufacturer().getId());
       if (manufacturer.isPresent()) {
           throw new NotFound("manufacturer not found");
       }
        product.setProductName(productRequest.getProductName());
       product.setPrice(productRequest.getPrice());
       product.setDiscount(productRequest.getDiscount());
       product.setDescription(productRequest.getDescription());
        return productMapper.toEntity(productDao.save(product));
    }
}

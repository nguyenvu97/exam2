package org.springframework.boot.exam2.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.exam2.dto.ProductDto;
import org.springframework.boot.exam2.dto.Request.Manufac_Request;
import org.springframework.boot.exam2.model.Manufacturer;
import org.springframework.boot.exam2.model.Product;
import org.springframework.boot.exam2.repository.ManufacturerDao;

import java.util.List;
@Mapper(config = MapperConfig.class,uses = ManufacturerDao.class )
public interface ProductMapper  extends MapperAll<Product, ProductDto>{



    @Override
    Product toDto(ProductDto productDto);

    @Override
    @Mappings({
             @Mapping(target = "name",expression = "java(product.getManufacturer().getName())"),
            @Mapping(target = "origin",expression = "java(product.getManufacturer().getOrigin())"),
            @Mapping(target = "description_Manufacturer",expression = "java(product.getManufacturer().getDescription())")
    })
    ProductDto toEntity(Product product);

    @Override
    List<Product> toListEntity(List<ProductDto> d);

    @Override


    List<ProductDto> toListDto(List<Product> products);

}

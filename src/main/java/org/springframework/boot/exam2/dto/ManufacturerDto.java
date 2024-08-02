package org.springframework.boot.exam2.dto;

import lombok.Getter;
import lombok.Setter;


import java.util.List;

@Setter
@Getter
public class ManufacturerDto {
    public long id;
    public String name;
    public String origin;
    public String description;
    List<ProductDto> products;
}

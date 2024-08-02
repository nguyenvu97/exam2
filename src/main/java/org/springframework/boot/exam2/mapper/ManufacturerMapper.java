package org.springframework.boot.exam2.mapper;

import org.mapstruct.Mapper;
import org.springframework.boot.exam2.dto.ManufacturerDto;
import org.springframework.boot.exam2.model.Manufacturer;

import java.util.List;
@Mapper(config = MapperConfig.class,uses = {ProductMapper.class})
public interface ManufacturerMapper  extends MapperAll<Manufacturer, ManufacturerDto> {
    @Override
    Manufacturer toDto(ManufacturerDto manufacturerDto);

    @Override
    ManufacturerDto toEntity(Manufacturer manufacturer);

    @Override
    List<Manufacturer> toListEntity(List<ManufacturerDto> d);

    @Override
    List<ManufacturerDto> toListDto(List<Manufacturer> e);
}

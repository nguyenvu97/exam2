package org.springframework.boot.exam2.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.exam2.dto.ManufacturerDto;
import org.springframework.boot.exam2.dto.Request.Manufac_Request;
import org.springframework.boot.exam2.exception.NotFound;
import org.springframework.boot.exam2.mapper.ManufacturerMapper;
import org.springframework.boot.exam2.model.Manufacturer;
import org.springframework.boot.exam2.repository.ManufacturerDao;
import org.springframework.boot.exam2.service.ManufacturerService;
import org.springframework.boot.exam2.service.ProductService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ManufacturerServiceImpl implements ManufacturerService {
    public final ManufacturerDao manufacturerDao;
    private final ProductService productService;
    private final ManufacturerMapper manufacturerMapper;


    @Override
    @Async
    public String add(Manufacturer manufacturer) {
        manufacturerDao.save(manufacturer);
        return "Ok";
    }

    @Override
    @Async
    public String delete(Long manufacturerId) {
      int count =   productService.countProduct(manufacturerId);
        if (count < 1){
            manufacturerDao.deleteById(manufacturerId);
            return "Ok";
        }
        throw  new NotFound("you can not delete manufacturer");
    }

    @Async
    @Override
    public ManufacturerDto update(long manufacturerId, Manufac_Request manufacRequest) {
        Manufacturer manufacturer1 = manufacturerDao.findById(manufacturerId).orElseThrow(()-> new NotFound("manufacturer not found"));
        manufacturer1.setName(manufacRequest.getName());
        manufacturer1.setOrigin(manufacRequest.getOrigin());
        manufacturer1.setDescription(manufacRequest.getDescription());
        return manufacturerMapper.toEntity(manufacturerDao.save(manufacturer1));
    }
}

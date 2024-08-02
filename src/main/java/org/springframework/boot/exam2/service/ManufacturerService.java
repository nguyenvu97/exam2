package org.springframework.boot.exam2.service;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.exam2.dto.ManufacturerDto;
import org.springframework.boot.exam2.dto.Request.Manufac_Request;
import org.springframework.boot.exam2.model.Manufacturer;
import org.springframework.stereotype.Service;


public interface ManufacturerService {

    String add(Manufacturer manufacturer);

    String delete(Long manufacturerId);

    ManufacturerDto update(long manufacturerId, Manufac_Request manufacRequest);


}

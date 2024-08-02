package org.springframework.boot.exam2.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.exam2.dto.Request.Manufac_Request;
import org.springframework.boot.exam2.exception.NotFound;
import org.springframework.boot.exam2.model.Manufacturer;
import org.springframework.boot.exam2.service.ManufacturerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/Manufacturer")
public class ManufacturerController {
    public final ManufacturerService manufacturerService;

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody Manufacturer manufacturer) {
        try {
            return ResponseEntity.ok().body(manufacturerService.add(manufacturer));

        }catch (NotFound e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    @PostMapping("/update")
    public ResponseEntity<?> update (@RequestBody Manufac_Request manufacRequest, @RequestParam long manufacturerId) {
        try {
            return ResponseEntity.ok().body(manufacturerService.update(manufacturerId, manufacRequest));

        }catch (NotFound e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    @DeleteMapping("/delete")
    public ResponseEntity<?> delete( @RequestParam Long manufacturerId) {
        try {
            return ResponseEntity.ok().body(manufacturerService.delete(manufacturerId));

        }catch (NotFound e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}

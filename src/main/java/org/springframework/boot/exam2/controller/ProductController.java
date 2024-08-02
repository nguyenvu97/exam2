package org.springframework.boot.exam2.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.exam2.dto.Request.Manufac_Request;
import org.springframework.boot.exam2.dto.Request.ProductRequest;
import org.springframework.boot.exam2.exception.NotFound;
import org.springframework.boot.exam2.model.Manufacturer;
import org.springframework.boot.exam2.model.Product;
import org.springframework.boot.exam2.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/product")
public class ProductController {
    public final ProductService productService;

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody List<Product> productList, @RequestParam long manufacturerId) {
        try {
            return ResponseEntity.ok().body(productService.add(productList,manufacturerId));

        }catch (NotFound e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    @PostMapping("/update")
    public ResponseEntity<?> update (@RequestBody ProductRequest productRequest) {
        try {
            return ResponseEntity.ok().body(productService.update(productRequest));

        }catch (NotFound e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    @DeleteMapping("/delete")
    public ResponseEntity<?> delete( @RequestParam Long productId) {
        try {
            return ResponseEntity.ok().body(productService.delete(productId));

        }catch (NotFound e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    @GetMapping("/search")
    public ResponseEntity<?> search( @RequestParam String productName) {
        try {
            return ResponseEntity.ok().body(productService.searchProduct(productName));

        }catch (NotFound e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}

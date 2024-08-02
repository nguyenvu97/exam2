package org.springframework.boot.exam2.repository;

import org.springframework.boot.exam2.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDao extends JpaRepository<Product, Long> {
    @Query("select count(p) from Product p where p.manufacturer.id = :manufacturerId")
    int countManufacturer(@Param(value = "manufacturerId")long manufacturerId);

    @Query("select p from Product p where p.productName like %:productName%")
    List<Product> findBySearch(@Param(value = "productName") String productName);
}

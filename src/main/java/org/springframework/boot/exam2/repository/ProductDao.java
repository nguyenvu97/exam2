package org.springframework.boot.exam2.repository;

import org.springframework.boot.exam2.model.Product;
import org.springframework.boot.exam2.projection.Manu_product;
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

    @Query("SELECT m.id as manuId, " +
            "m.name as manuName, " +
            "m.origin as manuOrigin, " +
            "m.description as manuDescription, " +
            "count(p) as products, "+
            "p as productList" +
            "FROM Manufacturer m " +
            "LEFT JOIN Product p ON p.manufacturer.id = m.id " +
            "WHERE p.productName LIKE %:productName%" +" GROUP BY  m.id")
    List<Manu_product> findByData(@Param("productName") String productName);

}

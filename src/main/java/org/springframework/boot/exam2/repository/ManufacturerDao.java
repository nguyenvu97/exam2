package org.springframework.boot.exam2.repository;

import org.springframework.boot.exam2.model.Manufacturer;
import org.springframework.boot.exam2.projection.Manu_product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ManufacturerDao extends JpaRepository<Manufacturer, Long> {
    @Query("SELECT m.id as manuId,m.name as manuName,m.origin as manuOrigin ,m.description as manuDescription FROM Manufacturer AS m WHERE m.id =:id ")
     List<Manu_product> findByData(@Param("id") Long id);
}

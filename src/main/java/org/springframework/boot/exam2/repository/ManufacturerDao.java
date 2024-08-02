package org.springframework.boot.exam2.repository;

import org.springframework.boot.exam2.model.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManufacturerDao extends JpaRepository<Manufacturer, Long> {
}

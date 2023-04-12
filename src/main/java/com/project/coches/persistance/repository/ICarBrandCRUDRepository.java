package com.project.coches.persistance.repository;

import com.project.coches.persistance.entity.CarBrandEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICarBrandCRUDRepository extends JpaRepository<CarBrandEntity, Integer> {
    
}

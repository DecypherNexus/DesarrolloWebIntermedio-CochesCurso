package com.project.coches.persistance.crud;

import com.project.coches.persistance.entity.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICarCRUDRepository extends JpaRepository<CarEntity, Integer> {

    List<CarEntity> findAllByCarBrandId(Integer carBrandId);

    List<CarEntity> findAllByPriceLessThanEqualOrderByPriceAsc(Double price);

}

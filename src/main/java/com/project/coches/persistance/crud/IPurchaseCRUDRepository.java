package com.project.coches.persistance.crud;

import com.project.coches.persistance.entity.PurchaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IPurchaseCRUDRepository extends JpaRepository<PurchaseEntity, Integer> {

    List<PurchaseEntity> findAllByCustomerCardId(String customerCardId);

}

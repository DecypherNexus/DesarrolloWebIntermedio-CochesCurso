package com.project.coches.persistance.crud;

import com.project.coches.persistance.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ICustomerCRUDRepository extends JpaRepository<CustomerEntity, String> {

    // Query Method
    // @Query("SELECT c FROM CustomerEntity c WHERE c.cardId = ?1")
    Optional<CustomerEntity> findByEmail(String email);

}

package com.project.coches.persistance.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * Entidad de "Marca_Coche"
 */
@Getter @Setter
@Entity
@Table(name = "marca_coche")
public class CarBrandEntity {

    /**
     * Id de la Marca
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Descripción de la Marca
     */
    @Column(name = "descripcion")
    private String description;

    /**
     * Relación de Uno a Muchos a "Coches"
     */
    @OneToMany(mappedBy = "carBrandEntity", orphanRemoval = true)
    private List<CarEntity> carEntities;

}

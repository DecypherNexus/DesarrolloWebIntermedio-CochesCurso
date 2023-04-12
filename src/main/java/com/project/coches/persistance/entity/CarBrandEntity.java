package com.project.coches.persistance.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

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

}

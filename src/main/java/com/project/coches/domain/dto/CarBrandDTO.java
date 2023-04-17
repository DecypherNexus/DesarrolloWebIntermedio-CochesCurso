package com.project.coches.domain.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * DTO de "Marca_Coche"
 */
@Getter
@Setter
public class CarBrandDTO {

    /**
     * Id de la Marca
     */
    private Integer id;

    /**
     * Descripción de la Marca
     */
    private String description;

}

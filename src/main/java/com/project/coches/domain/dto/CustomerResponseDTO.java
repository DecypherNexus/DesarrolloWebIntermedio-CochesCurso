package com.project.coches.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * DTO de Salida de "Cliente"
 */
@Getter @Setter
@AllArgsConstructor
public class CustomerResponseDTO {

    /**
     * Contraseña del Cliente
     */
    private String password;

}

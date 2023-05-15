package com.project.coches.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * DTO de Salida de "JWT"
 */
@Getter @Setter
@AllArgsConstructor
public class JWTResponseDTO {

    /**
     * JWT de la Autenticación
     */
    private String jwt;

}
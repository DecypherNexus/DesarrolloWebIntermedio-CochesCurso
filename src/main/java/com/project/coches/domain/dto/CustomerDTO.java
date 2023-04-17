package com.project.coches.domain.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * DTO de "Cliente"
 */
@Getter @Setter
public class CustomerDTO {

    /**
     * Cédula del Cliente
     */
    private String cardId;

    /**
     * Nombre Completo del Cliente
     */
    private String fullName;

    /**
     * Correo del Cliente
     */
    private String email;

    /**
     * Número de Celular del Cliente
     */
    private Double cellphoneNumber;

    /**
     * Estatus del Cliente
     */
    private Integer active;

    /**
     * Contraseña del Cliente
     */
    private String password;

}

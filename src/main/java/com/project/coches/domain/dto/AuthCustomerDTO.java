package com.project.coches.domain.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * DTO de "Autenticación"
 */
@Getter @Setter
public class AuthCustomerDTO {

    /**
     * Email del Cliente
     */
    private String email;

    /**
     * Password del Cliente
     */
    private String password;

}
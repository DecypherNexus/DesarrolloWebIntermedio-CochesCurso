package com.project.coches.domain.usecase;

import com.project.coches.domain.dto.AuthCustomerDTO;
import com.project.coches.domain.dto.JWTResponseDTO;

/**
 * Interfaz del Caso de Uso de "Autenticación"
 */
public interface IAuthUseCase {

    /**
     * Obtiene el JWT de Inicio de Sesión
     *
     * @param authCustomerDTO Recibe la Autenticación del Cliente
     * @return Devuelve el JWT de la Sesión Iniciada
     */
    JWTResponseDTO signIn(AuthCustomerDTO authCustomerDTO);

    /**
     * Obtiene el JWT de Cierre de Sesión
     *
     * @param jwt Recibe el JWT de Autenticación
     * @return Devuelve el JWT de la Sesión Cerrada
     */
    JWTResponseDTO signOut(String jwt);

}
package com.project.coches.domain.repository;

import com.project.coches.domain.dto.CustomerDTO;

import java.util.List;
import java.util.Optional;

/**
 * Interfaz del Repositorio de "Cliente"
 */
public interface ICustomerRepository {

    /**
     * Obtiene una Lista de Clientes
     *
     * @return Devuelve la Lista de los Clientes
     */
    List<CustomerDTO> getAll();

    /**
     * Obtiene un Cliente por la Cedula
     *
     * @param cardId Recibe la Cedula del Cliente a Buscar
     * @return Devuelve el Optional del Cliente Encontrado
     */
    Optional<CustomerDTO> getCustomer(String cardId);

    /**
     * Obtiene un Cliente por el Email
     *
     * @param email Recibe el Email del Cliente a Buscar
     * @return Devuelve el Optional del Cliente Encontrado
     */
    Optional<CustomerDTO> getCustomerByEmail(String email);

    /**
     * Guarda un Nuevo Cliente
     *
     * @param newCustomerDTO Recibe el Cliente a Guardar
     * @return Devuelve el Cliente Guardado
     */
    CustomerDTO save(CustomerDTO newCustomerDTO);

    /**
     * Elimina un Cliente por la Cedula
     *
     * @param cardId Recibe la Cedula del Cliente a Eliminar
     */
    void delete(String cardId);

}

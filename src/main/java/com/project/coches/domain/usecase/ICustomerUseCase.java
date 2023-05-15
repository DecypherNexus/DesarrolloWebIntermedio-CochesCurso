package com.project.coches.domain.usecase;

import com.project.coches.domain.dto.CustomerDTO;
import com.project.coches.domain.dto.CustomerResponseDTO;

import java.util.List;
import java.util.Optional;

/**
 * Interfaz del Caso de Uso de "Cliente"
 */
public interface ICustomerUseCase {

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
    CustomerResponseDTO save(CustomerDTO newCustomerDTO);

    /**
     * Actualiza un Cliente
     *
     * @param updatedCustomerDTO Recibe el Cliente a Actualizar
     * @return Devuelve el Cliente Actualizado
     */
    Optional<CustomerDTO> update(CustomerDTO updatedCustomerDTO);

    /**
     * Elimina un Cliente por la Cedula
     *
     * @param cardId Recibe la Cedula del Cliente a Eliminar
     * @return Devuelve un Valor "True" si se Eliminó y "False" si no se Eliminó
     */
    boolean delete(String cardId);

}

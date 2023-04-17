package com.project.coches.persistance.repository;

import com.project.coches.domain.dto.CustomerDTO;
import com.project.coches.domain.repository.ICustomerRepository;
import com.project.coches.persistance.crud.ICustomerCRUDRepository;
import com.project.coches.persistance.mapper.ICustomerMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repositorio de "Cliente"
 */
@RequiredArgsConstructor
@Repository
public class CustomerRepository implements ICustomerRepository {

    /**
     * CRUD de "Marca_Coche"
     */
    private final ICustomerCRUDRepository iCustomerCRUDRepository;

    /**
     * Mapper de "Marca_Coche"
     */
    private final ICustomerMapper iCustomerMapper;

    /**
     * Obtiene una Lista de Clientes
     *
     * @return Devuelve la Lista de los Clientes
     */
    @Override
    public List<CustomerDTO> getAll() {
        return iCustomerMapper.toCustomerDTOs(iCustomerCRUDRepository.findAll());
    }

    /**
     * Obtiene un Cliente por la Cedula
     *
     * @param cardId Recibe la Cedula del Cliente a Buscar
     * @return Devuelve el Optional del Cliente Encontrado
     */
    @Override
    public Optional<CustomerDTO> getCustomerByCardId(String cardId) {
        return iCustomerCRUDRepository.findById(cardId)
                .map(iCustomerMapper::toCustomerDTO);
    }

    /**
     * Obtiene un Cliente por el Email
     *
     * @param email Recibe el Email del Cliente a Buscar
     * @return Devuelve el Optional del Cliente Encontrado
     */
    @Override
    public Optional<CustomerDTO> getCustomerByEmail(String email) {
        return iCustomerCRUDRepository.findByEmail(email)
                .map(iCustomerMapper::toCustomerDTO);
    }

    /**
     * Guarda un Nuevo Cliente
     *
     * @param newCustomerDTO Recibe el Cliente a Guardar
     * @return Devuelve el Cliente Guardado
     */
    @Override
    public CustomerDTO save(CustomerDTO newCustomerDTO) {
        return iCustomerMapper
                .toCustomerDTO(iCustomerCRUDRepository
                        .save(iCustomerMapper
                                .toCustomerEntity(newCustomerDTO)));
    }

    /**
     * Elimina un Cliente por la Cedula
     *
     * @param cardId Recibe la Cedula del Cliente a Eliminar
     */
    @Override
    public void delete(String cardId) {
        iCustomerCRUDRepository.deleteById(cardId);
    }

}

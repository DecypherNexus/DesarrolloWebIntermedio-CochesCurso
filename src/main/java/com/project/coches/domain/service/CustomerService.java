package com.project.coches.domain.service;

import com.project.coches.domain.dto.CustomerDTO;
import com.project.coches.domain.dto.CustomerResponseDTO;
import com.project.coches.domain.repository.ICustomerRepository;
import com.project.coches.domain.usecase.ICustomerUseCase;
import com.project.coches.exception.EmailValidationException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.List;
import java.util.Optional;

/**
 * Servicio de "Cliente"
 */
@RequiredArgsConstructor
@Service
public class CustomerService implements ICustomerUseCase {

    /**
     * Repositorio de "Cliente"
     */
    private final ICustomerRepository iCustomerRepository;

    /**
     * Obtiene una Lista de Clientes
     *
     * @return Devuelve la Lista de los Clientes
     */
    @Override
    public List<CustomerDTO> getAll() {
        return iCustomerRepository.getAll();
    }

    /**
     * Obtiene un Cliente por la Cedula
     *
     * @param cardId Recibe la Cedula del Cliente a Buscar
     * @return Devuelve el Optional del Cliente Encontrado
     */
    @Override
    public Optional<CustomerDTO> getCustomerByCardId(String cardId) {
        return iCustomerRepository.getCustomerByCardId(cardId);
    }

    /**
     * Obtiene un Cliente por el Email
     *
     * @param email Recibe el Email del Cliente a Buscar
     * @return Devuelve el Optional del Cliente Encontrado
     */
    @Override
    public Optional<CustomerDTO> getCustomerByEmail(String email) {
        return iCustomerRepository.getCustomerByEmail(email);
    }

    /**
     * Guarda un Nuevo Cliente
     *
     * @param newCustomerDTO Recibe el Cliente a Guardar
     * @return Devuelve el Cliente Guardado
     */
    @Override
    public CustomerResponseDTO save(CustomerDTO newCustomerDTO) {

        if (!newCustomerDTO.getEmail().matches("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$")) {
            throw new EmailValidationException();
        }

        String generatedPassword = generateRandomPassword(8);
        newCustomerDTO.setPassword(generatedPassword);
        newCustomerDTO.setActive(1);
        iCustomerRepository.save(newCustomerDTO);

        return new CustomerResponseDTO(generatedPassword);

    }

    /**
     * Actualiza un Cliente
     *
     * @param updateCustomerDTO Recibe el Cliente a Actualizar
     * @return Devuelve el Cliente Actualizado
     */
    @Override
    public Optional<CustomerDTO> update(CustomerDTO updateCustomerDTO) {

        if (iCustomerRepository.getCustomerByCardId(updateCustomerDTO.getCardId()).isEmpty()) {
            return Optional.empty();
        }

        return Optional.of(iCustomerRepository.save(updateCustomerDTO));

    }

    /**
     * Elimina un Cliente por la Cedula
     *
     * @param cardId Recibe la Cedula del Cliente a Eliminar
     * @return Devuelve un Valor "True" si se Eliminó y "False" si no se Eliminó
     */
    @Override
    public boolean delete(String cardId) {

        if (iCustomerRepository.getCustomerByCardId(cardId).isEmpty()) {
            return false;
        }

        iCustomerRepository.delete(cardId);
        return true;

    }

    private String generateRandomPassword(int passwordLength) {

        // Rango ASCII - Alfanumérico (a-z, A-Z, 0-9)
        final String charRange = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

        SecureRandom secureRandom = new SecureRandom();
        StringBuilder stringBuilder = new StringBuilder();

        // En cada Iteración del Bucle se elige aleatoriamente un Carácter del Rango ASCII
        // y lo agrega a la Instancia de "StringBuilder"
        for (int i = 0; i < passwordLength; i++) {
            int randomIndex = secureRandom.nextInt(charRange.length());
            stringBuilder.append(charRange.charAt(randomIndex));
        }

        return stringBuilder.toString();

    }

}

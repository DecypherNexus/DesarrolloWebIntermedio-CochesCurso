package com.project.coches.domain.service;

import com.project.coches.security.JWTAuthenticationProvider;
import com.project.coches.domain.dto.AuthCustomerDTO;
import com.project.coches.domain.dto.CustomerDTO;
import com.project.coches.domain.dto.JWTResponseDTO;
import com.project.coches.domain.repository.ICustomerRepository;
import com.project.coches.domain.usecase.IAuthUseCase;
import com.project.coches.exception.CustomerNotExistsException;
import com.project.coches.exception.IncorrectPasswordException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Servicio de "Login" de Usuario
 */
@RequiredArgsConstructor
@Service
public class AuthService implements IAuthUseCase {

    /**
     * Repositorio de "Cliente"
     */
    private final ICustomerRepository iCustomerRepository;

    /**
     * Clase que Administra los JWTs
     */
    private final JWTAuthenticationProvider jwtAuthenticationProvider;

    /**
     * Clase que Encripta Contraseñas
     */
    private final PasswordEncoder passwordEncoder;

    /**
     * Devuelve un DTO con el JWT del Usuario dadas unas Credenciales
     *
     * @param authCustomerDTO Recibe las Credenciales de Acceso
     * @return Devuelve el DTO con el JWT del Usuario si las Credenciales son Válidas
     */
    public JWTResponseDTO signIn(AuthCustomerDTO authCustomerDTO) {

        Optional<CustomerDTO> customerDTO = iCustomerRepository.getCustomerByEmail(authCustomerDTO.getEmail());

        if (customerDTO.isEmpty()) {
            throw new CustomerNotExistsException();
        }

        if (!passwordEncoder.matches(authCustomerDTO.getPassword(), customerDTO.get().getPassword())) {
            throw new IncorrectPasswordException();
        }

        return new JWTResponseDTO(jwtAuthenticationProvider.createToken(customerDTO.get()));

    }

    /**
     * Cierra la Sesión Eliminando de la Lista Blanca el Token Ingresado
     *
     * @param token Recibe el Token del Usuario a Eliminar
     * @return Devuelve el DTO del Usuario Eliminado
     */
    public JWTResponseDTO signOut(String token) {

        String[] authElements = token.split(" ");
        return new JWTResponseDTO(jwtAuthenticationProvider.deleteToken(authElements[1]));

    }

}
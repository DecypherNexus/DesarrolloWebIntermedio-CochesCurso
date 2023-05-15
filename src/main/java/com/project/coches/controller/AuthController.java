package com.project.coches.controller;

import com.project.coches.domain.dto.AuthCustomerDTO;
import com.project.coches.domain.dto.CustomerDTO;
import com.project.coches.domain.dto.JWTResponseDTO;
import com.project.coches.domain.dto.CustomerResponseDTO;
import com.project.coches.domain.usecase.IAuthUseCase;
import com.project.coches.domain.usecase.ICustomerUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador REST de "Autenticación"
 */
@CrossOrigin
@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/auth")
public class AuthController {

    /**
     * Caso de Uso de "Autenticación"
     */
    private final IAuthUseCase iAuthUseCase;

    /**
     * Caso de Uso de "Cliente"
     */
    private final ICustomerUseCase iCustomerUseCase;

    /**
     * Guarda un Nuevo Registro de Autenticación de Cliente
     *
     * @param newCustomerDTO Recibe el Cliente a Guardar
     * @return Devuelve un Código Http "CREATED" en el caso de que el Registro de Autenticación de Cliente haya sido guardado o un Código Http "BAD REQUEST" en el caso contrario
     */
    @PostMapping(path = "/register")
    public ResponseEntity<CustomerResponseDTO> save(@RequestBody CustomerDTO newCustomerDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(iCustomerUseCase.save(newCustomerDTO));
    }

    /**
     * Obtiene el JWT de Inicio de Sesión
     *
     * @param authCustomerDTO Recibe las Credenciales de Acceso
     * @return Devuelve un Código Http "OK" con la Sesión Iniciada
     */
    @PostMapping(path = "/sign-in")
    public ResponseEntity<JWTResponseDTO> signIn(@RequestBody AuthCustomerDTO authCustomerDTO) {
        return ResponseEntity.ok(iAuthUseCase.signIn(authCustomerDTO));
    }

    /**
     * Obtiene el JWT de Cierre de Sesión
     *
     * @param jwt Recibe el Token del Usuario
     * @return Devuelve un Código Http "OK" con la Sesión Cerrada
     */
    @PostMapping(path = "/sign-out")
    public ResponseEntity<JWTResponseDTO> signOut(@RequestHeader(name = HttpHeaders.AUTHORIZATION) String jwt) {
        return ResponseEntity.ok(iAuthUseCase.signOut(jwt));
    }

}
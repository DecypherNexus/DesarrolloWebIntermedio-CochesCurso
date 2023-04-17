package com.project.coches.controller;

import com.project.coches.domain.dto.CustomerDTO;
import com.project.coches.domain.dto.CustomerResponseDTO;
import com.project.coches.domain.usecase.ICustomerUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST de "Cliente"
 */
@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/customers")
public class CustomerController {

    /**
     * Caso de Uso de "Cliente"
     */
    private final ICustomerUseCase iCustomerUseCase;

    /**
     * Obtiene una Lista de Clientes
     *
     * @return Devuelve un Código Http "OK" con la Lista de los Clientes
     */
    @GetMapping()
    public ResponseEntity<List<CustomerDTO>> getAll() {
        return ResponseEntity.ok(iCustomerUseCase.getAll());
    }

    /**
     * Obtiene un Cliente por la Cedula
     *
     * @param cardId Recibe la Cedula del Cliente a Buscar
     * @return Devuelve un Código Http "OK" en el caso de que el Cliente haya sido encontrado o un Código Http "NOT FOUND" en el caso contrario
     */
    @GetMapping(path = "/{cardId}")
    public ResponseEntity<CustomerDTO> getCustomerByCardId(@PathVariable String cardId) {
        return ResponseEntity.of(iCustomerUseCase.getCustomerByCardId(cardId));
    }

    /**
     * Obtiene un Cliente por el Email
     *
     * @param email Recibe el Email del Cliente a Buscar
     * @return Devuelve un Código Http "OK" en el caso de que el Cliente haya sido encontrado o un Código Http "NOT FOUND" en el caso contrario
     */
    @GetMapping(path = "/email/{email}")
    public ResponseEntity<CustomerDTO> getCustomerByEmail(@PathVariable String email) {
        return ResponseEntity.of(iCustomerUseCase.getCustomerByEmail(email));
    }

    /**
     * Guarda un Nuevo Cliente
     *
     * @param newCustomerDTO Recibe el Cliente a Guardar
     * @return Devuelve un Código Http "CREATED" en el caso de que el Cliente haya sido guardado o un Código Http "BAD REQUEST" en el caso contrario
     */
    @PostMapping()
    public ResponseEntity<CustomerResponseDTO> save(@RequestBody CustomerDTO newCustomerDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(iCustomerUseCase.save(newCustomerDTO));
    }

    /**
     * Actualiza un Cliente
     *
     * @param updatedCustomerDTO Recibe el Cliente a Actualizar
     * @return Devuelve un Código Http "OK" en el caso de que el Cliente haya sido actualizado o un Código Http "BAD REQUEST" en el caso contrario
     */
    @PatchMapping()
    public ResponseEntity<CustomerDTO> update(@RequestBody CustomerDTO updatedCustomerDTO) {
        return ResponseEntity.of(iCustomerUseCase.update(updatedCustomerDTO));
    }

    /**
     * Elimina un Cliente por la Cedula
     *
     * @param cardId Recibe la Cedula del Cliente a Eliminar
     * @return Devuelve un Código Http "OK" en el caso de que el Cliente haya sido eliminado o un Código Http "NOT FOUND" en el caso contrario
     */
    @DeleteMapping(path = "/{cardId}")
    public ResponseEntity<Boolean> delete(@PathVariable String cardId) {
        return new ResponseEntity<>(iCustomerUseCase.delete(cardId) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }


}

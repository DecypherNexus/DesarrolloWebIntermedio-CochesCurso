package com.project.coches.controller;

import com.project.coches.domain.dto.PurchaseBillResponseDTO;
import com.project.coches.domain.dto.PurchaseRequestDTO;
import com.project.coches.domain.dto.PurchaseResponseDTO;
import com.project.coches.domain.usecase.IPurchaseUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST de "Compras"
 */
@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/purchases")
public class PurchaseController {

    /**
     * Caso de Uso de "Compras"
     */
    private final IPurchaseUseCase iPurchaseUseCase;

    /**
     * Obtiene una Lista de Compras
     *
     * @return Devuelve un Código Http "OK" con la Lista de las Compras
     */
    @GetMapping()
    public ResponseEntity<List<PurchaseResponseDTO>> getAll() {
        return ResponseEntity.ok(iPurchaseUseCase.getAll());
    }

    /**
     * Obtiene una Lista de Compras por la Cédula del Cliente
     *
     * @param customerCardId Recibe la Cédula del Cliente de las Compras a Buscar
     * @return Devuelve un Código Http "OK" con la Lista de las Compras
     */
    @GetMapping(path = "/customers/{customerCardId}")
    public ResponseEntity<List<PurchaseResponseDTO>> getAllByCustomerCardId(@PathVariable String customerCardId) {
        return ResponseEntity.ok(iPurchaseUseCase.getAllByCustomerCardId(customerCardId));
    }

    /**
     * Obtiene una Compra por el Número de Factura
     *
     * @param billNumber Recibe el Número de Factura de la Compra a Buscar
     * @return Devuelve un Código Http "OK" con la Compra Encontrada
     */
    @GetMapping(path = "/{billNumber}")
    public ResponseEntity<PurchaseResponseDTO> getPurchase(@PathVariable Integer billNumber) {
        return ResponseEntity.ok(iPurchaseUseCase.getPurchase(billNumber));
    }

    /**
     * Guarda una Nueva Compra
     *
     * @param purchaseRequestDTO Recibe la Compra a Guardar
     * @return Devuelve un Código Http "CREATED" en el caso de que la Compra haya sido guardada o un Código Http "BAD REQUEST" en el caso contrario
     */
    @PostMapping()
    public ResponseEntity<PurchaseBillResponseDTO> savePurchase(@RequestBody PurchaseRequestDTO purchaseRequestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(iPurchaseUseCase.save(purchaseRequestDTO));
    }

}
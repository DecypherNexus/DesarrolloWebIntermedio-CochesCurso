package com.project.coches.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * DTO de Salida de "Factura Compra"
 */
@Getter @Setter
@AllArgsConstructor
public class PurchaseBillResponseDTO {

    /**
     * Número de Factura de la Compra
     */
    private Integer billNumber;

}
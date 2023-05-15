package com.project.coches.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * DTO de Salida de "Coches_Compras"
 */
@Getter @Setter
@AllArgsConstructor
public class CarPurchaseResponseDTO {

    /**
     * Referencia de los Coches de la Compra
     */
    private String carReference;

    /**
     * Cantidad de los Coches de la Compra
     */
    private Integer quantity;

    /**
     * Total de los Coches de la Compra
     */
    private Integer total;

}

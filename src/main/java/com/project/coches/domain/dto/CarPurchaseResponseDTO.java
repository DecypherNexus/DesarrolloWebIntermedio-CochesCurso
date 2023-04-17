package com.project.coches.domain.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * DTO de Salida de "Coches_Compras"
 */
@Getter @Setter
public class CarPurchaseResponseDTO {

    /**
     * Referencia de los Coches de la Compra
     */
    private String carReference;

    /**
     * Cantidad de los Coches de la Compra
     */
    private Double quantity;

    /**
     * Total de los Coches de la Compra
     */
    private Double total;

}

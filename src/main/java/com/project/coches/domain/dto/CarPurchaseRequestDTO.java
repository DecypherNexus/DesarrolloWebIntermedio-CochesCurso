package com.project.coches.domain.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * DTO de Entrada de "Coches_Compras"
 */
@Getter @Setter
public class CarPurchaseRequestDTO {

    /**
     * Número de Factura de la Compra
     */
    private Integer purchaseBillNumber;

    /**
     * Código de los Coches de la Compra
     */
    private Integer carCarCode;

    /**
     * Cantidad de los Coches de la Compra
     */
    private Integer quantity;

    /**
     * Total de los Coches de la Compra
     */
    private Integer total;

}

package com.project.coches.domain.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

/**
 * DTO de Entrada de "Compras"
 */
@Getter @Setter
public class PurchaseRequestDTO {

    /**
     * Número de Factura de la Compra
     */
    private Integer billNumber;

    /**
     * Cédula del Cliente de la Compra
     */
    private String customerCardId;

    /**
     * Fecha de la Compra
     */
    private LocalDateTime date;

    /**
     * Total de la Compra
     */
    private Double total;

    /**
     * Medio de Pago de la Compra
     */
    private String paymentMethod;

    /**
     * Lista de los Carros de la Compra
     */
    private List<CarPurchaseRequestDTO> purchaseCars;

}

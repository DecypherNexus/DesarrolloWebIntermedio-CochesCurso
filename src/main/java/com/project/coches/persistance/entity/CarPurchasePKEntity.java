package com.project.coches.persistance.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

/**
 * Entidad de Llave Primaria de "Coches_Compras"
 */
@Getter @Setter
@Embeddable
public class CarPurchasePKEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = -2145479604343286721L;

    /**
     * Número de Factura de la Compra
     */
    @Column(name = "compras_numero_factura")
    private Integer purchaseBillNumber;

    /**
     * Código de los Coches de la Compra
     */
    @Column(name = "coches_codigo_coche")
    private Integer carCarCode;

}

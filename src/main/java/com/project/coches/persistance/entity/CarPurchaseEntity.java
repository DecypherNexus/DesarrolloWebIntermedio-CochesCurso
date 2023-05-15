package com.project.coches.persistance.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * Entidad de "Coches_Compras"
 */
@Getter @Setter
@Entity
@Table(name = "coches_compras")
public class CarPurchaseEntity {

    /**
     * Llave Primaria de "Coches_Compras"
     */
    @EmbeddedId
    private CarPurchasePKEntity carPurchasePK;

    /**
     * Cantidad de los Coches de la Compra
     */
    @Column(name = "cantidad")
    private Integer quantity;

    /**
     * Total de los Coches de la Compra
     */
    @Column(name = "total")
    private Integer total;

    /**
     * Relación de Muchos a Uno a "Coches"
     */
    @ManyToOne
    @JoinColumn(name = "coches_codigo_coche", insertable = false, updatable = false)
    private CarEntity carEntity;

    /**
     * Relación de Muchos a Uno a "Compras"
     */
    @ManyToOne
    @MapsId(value = "purchaseBillNumber")
    @JoinColumn(name = "compras_numero_factura", insertable = false, updatable = false)
    private PurchaseEntity purchaseEntity;

}

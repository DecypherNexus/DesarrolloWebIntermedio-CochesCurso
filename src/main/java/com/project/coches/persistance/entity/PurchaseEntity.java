package com.project.coches.persistance.entity;

import com.project.coches.domain.dto.CarPurchaseRequestDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Entidad de "Compras"
 */
@Getter @Setter
@Entity
@Table(name = "compras")
public class PurchaseEntity {

    /**
     * Número de Factura de la Compra
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "numero_factura")
    private Integer billNumber;

    /**
     * Cédula del Cliente de la Compra
     */
    @Column(name = "cliente_cedula")
    private String customerCardId;

    /**
     * Fecha de la Compra
     */
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime date;

    /**
     * Total de la Compra
     */
    @Column(name = "total")
    private Double total;

    /**
     * Medio de Pago de la Compra
     */
    @Column(name = "medio_pago")
    private String paymentMethod;

    /**
     * Relación de Muchos a Uno a "Cliente"
     */
    @ManyToOne
    @JoinColumn(name = "cliente_cedula", insertable = false, updatable = false)
    private CustomerEntity customerEntity;

    /**
     * Relación de Uno a Muchos a "Coches_Compras"
     */
    @OneToMany(mappedBy = "purchaseEntity", cascade = {CascadeType.ALL})
    private List<CarPurchaseEntity> carPurchaseEntities;

}

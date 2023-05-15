package com.project.coches.persistance.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Entidad de "Cliente"
 */
@Getter @Setter
@Entity
@Table(name = "cliente")
public class CustomerEntity {

    /**
     * Cédula del Cliente
     */
    @Id
    @Column(name = "cedula")
    private String cardId;

    /**
     * Nombre Completo del Cliente
     */
    @Column(name = "nombre_completo")
    private String fullName;

    /**
     * Correo del Cliente
     */
    @Column(name = "correo")
    private String email;

    /**
     * Número de Celular del Cliente
     */
    @Column(name = "numero_celular")
    private Double cellphoneNumber;

    /**
     * Estatus del Cliente
     */
    @Column(name = "activo")
    private Integer active;

    /**
     * Contraseña del Cliente
     */
    @Column(name = "contrasenia")
    private String password;

    /**
     * Contraseña del Cliente
     */
    @Column(name = "rol")
    private String role;

    /**
     * Relación de Uno a Muchos a "Compras"
     */
    @OneToMany(mappedBy = "customerEntity")
    private List<PurchaseEntity> purchaseEntities;

}

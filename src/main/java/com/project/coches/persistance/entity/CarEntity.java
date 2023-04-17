package com.project.coches.persistance.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Entidad de "Coches"
 */
@Getter @Setter
@Entity
@Table (name = "coches")
public class CarEntity {

    /**
     * Código del Coche
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_coche")
    private Integer carCode;

    /**
     * Id de la Marca del Coche
     */
    @Column(name = "marca_coche_id")
    private Integer carBrandId;

    /**
     * Referencia del Coche
     */
    @Column(name = "referencia")
    private String reference;

    /**
     * Precio del Coche
     */
    @Column(name = "precio")
    private Double price;

    /**
     * Año del Modelo del Coche
     */
    @Column(name = "anio_modelo")
    private Double modelYear;

    /**
     * Color del Coche
     */
    @Column(name = "color")
    private String color;

    /**
     * Número de Caballos de Fuerza del Coche
     */
    @Column(name = "numero_caballos_fuerza")
    private Double horsepower;

    /**
     * Cantidad de Puertas del Coche
     */
    @Column(name = "cantidad_puertas")
    private Integer doorNumber;

    /**
     * Cilindraje del Coche
     */
    @Column(name = "cilindraje")
    private Double engineDisplacement;

    /**
     * Transmisión del Coche
     */
    @Column(name = "transmision")
    private String transmission;

    /**
     * Tipo de Combustible del Coche
     */
    @Column(name = "tipo_combustible")
    private String fuelType;

    /**
     * Cantidad de Asientos del Coche
     */
    @Column(name = "cantidad_asientos")
    private Integer seatNumber;

    /**
     * Tracción del Coche
     */
    @Column(name = "traccion")
    private Integer traction;

    /**
     * Dirección del Coche
     */
    @Column(name = "direccion")
    private String steering;

    /**
     * Categoría del Coche
     */
    @Column(name = "categoria")
    private String category;

    /**
     * Ruta de la Imagen del Coche
     */
    @Column(name = "ruta_imagen")
    private String imagePath;

    /**
     * Relación de Muchos a Uno a "Marca_Coche"
     */
    @ManyToOne
    @JoinColumn(name = "marca_coche_id", insertable = false, updatable = false)
    private CarBrandEntity carBrandEntity;

    /**
     * Relación de Uno a Muchos a "Coches_Compras"
     */
    @OneToMany(mappedBy = "carEntity")
    private List<CarPurchaseEntity> carPurchaseEntities;

}

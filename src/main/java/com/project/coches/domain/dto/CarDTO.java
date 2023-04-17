package com.project.coches.domain.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * DTO de "Coches"
 */
@Getter @Setter
public class CarDTO {

    /**
     * Código del Coche
     */
    private Integer carCode;

    /**
     * Id de la Marca del Coche
     */
    private Integer carBrandId;

    /**
     * Referencia del Coche
     */
    private String reference;

    /**
     * Precio del Coche
     */
    private Double price;

    /**
     * Año del Modelo del Coche
     */
    private Double modelYear;

    /**
     * Color del Coche
     */
    private String color;

    /**
     * Número de Caballos de Fuerza del Coche
     */
    private Double horsepower;

    /**
     * Cantidad de Puertas del Coche
     */
    private Integer doorNumber;

    /**
     * Cilindraje del Coche
     */
    private Double engineDisplacement;

    /**
     * Transmisión del Coche
     */
    private String transmission;

    /**
     * Tipo de Combustible del Coche
     */
    private String fuelType;

    /**
     * Cantidad de Asientos del Coche
     */
    private Integer seatNumber;

    /**
     * Tracción del Coche
     */
    private Integer traction;

    /**
     * Dirección del Coche
     */
    private String steering;

    /**
     * Categoría del Coche
     */
    private String category;

    /**
     * Ruta de la Imagen del Coche
     */
    private String imagePath;

}

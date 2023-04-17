package com.project.coches.persistance.mapper;

import com.project.coches.domain.dto.CarDTO;
import com.project.coches.persistance.entity.CarEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

/**
 * Mapper que Convierte Objetos de "Coches" a DTOs / a Entidades
 */
@Mapper(componentModel = "spring")
public interface ICarMapper {

    /**
     * Convierte una Entidad a un DTO de "Coches"
     * @param carEntity Recibe una Entidad
     * @return Devuelve un DTO
     */
    @Mapping(source = "carCode", target = "carCode")
    @Mapping(source = "carBrandId", target = "carBrandId")
    @Mapping(source = "reference", target = "reference")
    @Mapping(source = "price", target = "price")
    @Mapping(source = "modelYear", target = "modelYear")
    @Mapping(source = "color", target = "color")
    @Mapping(source = "horsepower", target = "horsepower")
    @Mapping(source = "doorNumber", target = "doorNumber")
    @Mapping(source = "engineDisplacement", target = "engineDisplacement")
    @Mapping(source = "transmission", target = "transmission")
    @Mapping(source = "fuelType", target = "fuelType")
    @Mapping(source = "seatNumber", target = "seatNumber")
    @Mapping(source = "traction", target = "traction")
    @Mapping(source = "steering", target = "steering")
    @Mapping(source = "category", target = "category")
    @Mapping(source = "imagePath", target = "imagePath")
    CarDTO toCarDTO(CarEntity carEntity);

    /**
     * Convierte un DTO a una Entidad de "Coches"
     * @param carDTO Recibe un DTO
     * @return Devuelve una Entidad
     */
    @InheritInverseConfiguration
    @Mapping(target = "carBrandEntity", ignore = true)
    @Mapping(target = "carPurchaseEntities", ignore = true)
    CarEntity toCarEntity(CarDTO carDTO);

    /**
     * Convierte una Lista de Entidades a una Lista de DTOs de "Coches"
     * @param carEntities Recibe una Lista de Entidades
     * @return Devuelve una Lista de DTOs
     */
    List<CarDTO> toCarDTOs(List<CarEntity> carEntities);

}

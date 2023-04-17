package com.project.coches.persistance.mapper;

import com.project.coches.domain.dto.CarBrandDTO;
import com.project.coches.persistance.entity.CarBrandEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

/**
 * Mapper que Convierte Objetos de "Marca_Coche" a DTOs / a Entidades
 */
@Mapper(componentModel = "spring")
public interface ICarBrandMapper {

    /**
     * Convierte una Entidad a un DTO de "Marca_Coche"
     *
     * @param carBrandEntity Recibe una Entidad
     * @return Devuelve un DTO
     */
    @Mapping(source = "id", target = "id")
    @Mapping(source = "description", target = "description")
    CarBrandDTO toCarBrandDTO(CarBrandEntity carBrandEntity);

    /**
     * Convierte un DTO a una Entidad de "Marca_Coche"
     *
     * @param carBrandDTO Recibe un DTO
     * @return Devuelve una Entidad
     */
    @InheritInverseConfiguration
    @Mapping(target = "carEntities", ignore = true)
    CarBrandEntity toCarBrandEntity(CarBrandDTO carBrandDTO);

    /**
     * Convierte una Lista de Entidades a una Lista de DTOs de "Marca_Coche"
     *
     * @param carBrandEntities Recibe una Lista de Entidades
     * @return Devuelve una Lista de DTOs
     */
    List<CarBrandDTO> toCarBrandDTOs(List<CarBrandEntity> carBrandEntities);

}

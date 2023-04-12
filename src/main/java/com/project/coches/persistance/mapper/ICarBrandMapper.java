package com.project.coches.persistance.mapper;

import com.project.coches.domain.pojo.CarBrandPojo;
import com.project.coches.persistance.entity.CarBrandEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

/**
 * Mapper que Convierte Objetos de "Marca_Coche" a Pojos / a Entidades
 */
@Mapper(componentModel = "spring")
public interface ICarBrandMapper {

    /**
     * Convierte una Entidad a un Pojo de "Marca_Coche"
     * @param marcaCocheEntity Recibe una Entidad
     * @return Devuelve un Pojo
     */
    @Mapping(source = "id", target = "id")
    @Mapping(source = "description", target = "description")
    CarBrandPojo toCarBrandPojo(CarBrandEntity carBrandEntity);

    /**
     * Convierte un Pojo a una Entidad de "Marca_Coche"
     * @param marcaCochePojo Recibe un Pojo
     * @return Devuelve una Entidad
     */
    @InheritInverseConfiguration
    CarBrandEntity toCarBrandEntity(CarBrandPojo carBrandPojo);

    /**
     * Convierte una Lista de Entidades a una Lista de Pojos de "Marca_Coche"
     * @param marcaCocheEntities Recibe una Lista de Entidades
     * @return Devuelve una Lista de Pojos
     */
    List<CarBrandPojo> toCarBrandPojos(List<CarBrandEntity> carBrandEntities);

}

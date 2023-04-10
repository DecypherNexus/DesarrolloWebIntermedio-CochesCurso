package com.project.coches.persistance.mapper;

import com.project.coches.domain.pojo.MarcaCochePojo;
import com.project.coches.persistance.entity.MarcaCocheEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

/**
 * Mapper que transforma Objetos de "Marca_Coche" a Pojos o a Entidades
 */
@Mapper(componentModel = "spring")
public interface IMarcaCocheMapper {

    /**
     * Convierte una Entidad a un Pojo de "Marca_Coche"
     * @param marcaCocheEntity Recibe una Entidad
     * @return Retorna un Pojo
     */
    @Mapping(source = "id", target = "id")
    @Mapping(source = "description", target = "description")
    MarcaCochePojo toMarcaCochePojo(MarcaCocheEntity marcaCocheEntity);

    /**
     * Convierte un Pojo a una Entidad de "Marca_Coche"
     * @param marcaCochePojo Recibe un Pojo
     * @return Retorna una Entidad
     */
    @InheritInverseConfiguration
    MarcaCocheEntity toMarcaCocheEntity(MarcaCochePojo marcaCochePojo);

    /**
     * Convierte una Lista de Entidades a una Lista de Pojos de "Marca_Coche"
     * @param marcaCocheEntities Recibe una Lista de Entidades
     * @return Retorna una Lista de Pojos
     */
    List<MarcaCochePojo> toMarcaCochePojos(List<MarcaCocheEntity> marcaCocheEntities);

}

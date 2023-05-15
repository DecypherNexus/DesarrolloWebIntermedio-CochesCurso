package com.project.coches.persistance.mapper;

import com.project.coches.domain.dto.CustomerDTO;
import com.project.coches.persistance.entity.CustomerEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

/**
 * Mapper que Convierte Objetos de "Cliente" a DTOs / a Entidades
 */
@Mapper(componentModel = "spring")
public interface ICustomerMapper {

    /**
     * Convierte una Entidad a un DTO de "Cliente"
     *
     * @param customerEntity Recibe una Entidad
     * @return Devuelve un DTO
     */
    @Mapping(source = "cardId", target = "cardId")
    @Mapping(source = "fullName", target = "fullName")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "cellphoneNumber", target = "cellphoneNumber")
    @Mapping(source = "active", target = "active")
    @Mapping(source = "password", target = "password")
    @Mapping(source = "role", target = "role")
    CustomerDTO toCustomerDTO(CustomerEntity customerEntity);

    /**
     * Convierte un DTO a una Entidad de "Cliente"
     *
     * @param customerDTO Recibe un DTO
     * @return Devuelve una Entidad
     */
    @InheritInverseConfiguration
    @Mapping(target = "purchaseEntities", ignore = true)
    CustomerEntity toCustomerEntity(CustomerDTO customerDTO);

    /**
     * Convierte una Lista de Entidades a una Lista de DTOs de "Cliente"
     *
     * @param customerEntities Recibe una Lista de Entidades
     * @return Devuelve una Lista de DTOs
     */
    List<CustomerDTO> toCustomerDTOs(List<CustomerEntity> customerEntities);

}

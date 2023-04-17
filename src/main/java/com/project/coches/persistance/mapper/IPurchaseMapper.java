package com.project.coches.persistance.mapper;

import com.project.coches.domain.dto.PurchaseRequestDTO;
import com.project.coches.persistance.entity.PurchaseEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

/**
 * Mapper que Convierte Objetos de "Compras" a DTOs / a Entidades
 */
@Mapper(componentModel = "spring")
public interface IPurchaseMapper {

    /**
     * Convierte una Entidad a un DTO de "Compras"
     * @param purchaseEntity Recibe una Entidad
     * @return Devuelve un DTO
     */
    @Mapping(source = "numero_factura", target = "numero_factura")
    @Mapping(source = "cliente_cedula", target = "cliente_cedula")
    @Mapping(source = "fecha", target = "fecha")
    @Mapping(source = "total", target = "total")
    @Mapping(source = "medio_pago", target = "medio_pago")
    PurchaseRequestDTO toPurchaseRequestDTO(PurchaseEntity purchaseEntity);

    /**
     * Convierte un DTO a una Entidad de "Compras"
     * @param purchaseRequestDTO Recibe un DTO
     * @return Devuelve una Entidad
     */
    @InheritInverseConfiguration
    @Mapping(target = "customerEntity", ignore = true)
    PurchaseEntity toPurchaseEntity(PurchaseRequestDTO purchaseRequestDTO);

    /**
     * Convierte una Lista de Entidades a una Lista de DTOs de "Compras"
     * @param purchaseEntities Recibe una Lista de Entidades
     * @return Devuelve una Lista de DTOs
     */
    List<PurchaseRequestDTO> toPurchaseRequestDTOs(List<PurchaseEntity> purchaseEntities);

}

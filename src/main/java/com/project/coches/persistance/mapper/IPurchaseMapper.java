package com.project.coches.persistance.mapper;

import com.project.coches.domain.dto.PurchaseRequestDTO;
import com.project.coches.persistance.entity.PurchaseEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Mapper que Convierte Objetos de "Compras" a DTOs / a Entidades
 */
@Mapper(componentModel = "spring", uses = {ICarPurchaseMapper.class})
public interface IPurchaseMapper {

    /**
     * Convierte un DTO a una Entidad de "Compras"
     *
     * @param purchaseRequestDTO Recibe un DTO
     * @return Devuelve una Entidad
     */
    @Mapping(target = "customerEntity", ignore = true)
    PurchaseEntity toPurchaseEntity(PurchaseRequestDTO purchaseRequestDTO);

}

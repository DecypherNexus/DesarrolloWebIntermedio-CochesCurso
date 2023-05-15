package com.project.coches.persistance.mapper;

import com.project.coches.domain.dto.CarPurchaseRequestDTO;
import com.project.coches.persistance.entity.CarPurchaseEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Mapper que Convierte Objetos de "Coches_Compras" a Entidades
 */
@Mapper(componentModel = "spring")
public interface ICarPurchaseMapper {

    /**
     * Convierte un DTO a una Entidad de "Coches_Compras"
     *
     * @param carPurchaseRequestDTO Recibe un DTO
     * @return Devuelve una Entidad
     */
    @Mapping(source = "carCarCode", target = "carPurchasePK.carCarCode")
    @Mapping(target = "purchaseEntity", ignore = true)
    @Mapping(target = "carEntity", ignore = true)
    @Mapping(target = "carPurchasePK.purchaseBillNumber", ignore = true)
    CarPurchaseEntity toCarPurchaseEntity(CarPurchaseRequestDTO carPurchaseRequestDTO);

}
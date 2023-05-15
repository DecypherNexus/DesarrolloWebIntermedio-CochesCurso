package com.project.coches.persistance.repository;

import com.project.coches.domain.dto.CarPurchaseResponseDTO;
import com.project.coches.domain.dto.PurchaseBillResponseDTO;
import com.project.coches.domain.dto.PurchaseRequestDTO;
import com.project.coches.domain.dto.PurchaseResponseDTO;
import com.project.coches.domain.repository.IPurchaseRepository;
import com.project.coches.persistance.crud.IPurchaseCRUDRepository;
import com.project.coches.persistance.entity.PurchaseEntity;
import com.project.coches.persistance.mapper.IPurchaseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Repositorio de "Compras"
 */
@RequiredArgsConstructor
@Repository
public class PurchaseRepository implements IPurchaseRepository {

    /**
     * CRUD de "Compras"
     */
    private final IPurchaseCRUDRepository iPurchaseCRUDRepository;

    /**
     * Mapper de "Compras"
     */
    private final IPurchaseMapper iPurchaseMapper;

    /**
     * Obtiene una Lista de Clientes
     *
     * @return Devuelve la Lista de los Clientes
     */
    @Override
    public List<PurchaseResponseDTO> getAll() {

        List<PurchaseEntity> purchaseEntityList = iPurchaseCRUDRepository.findAll();
        List<PurchaseResponseDTO> purchaseResponseDTOList = new ArrayList<>();
        purchaseEntityList.forEach(purchaseEntity -> purchaseResponseDTOList.add(toPurchaseResponseDTOByEntity(purchaseEntity)));

        return purchaseResponseDTOList;

    }

    /**
     * Obtiene una Lista de Compras por la Cédula del Cliente
     *
     * @param customerCardId Recibe la Cédula del Cliente de las Compras a Buscar
     * @return Devuelve la Lista de las Compras Encontradas
     */
    @Override
    public List<PurchaseResponseDTO> getAllByCustomerCardId(String customerCardId) {

        List<PurchaseEntity> purchaseEntityList = iPurchaseCRUDRepository.findAllByCustomerCardId(customerCardId);
        List<PurchaseResponseDTO> purchaseResponseDTOList = new ArrayList<>();
        purchaseEntityList.forEach(purchaseEntity -> purchaseResponseDTOList.add(toPurchaseResponseDTOByEntity(purchaseEntity)));

        return purchaseResponseDTOList;

    }

    /**
     * Obtiene una Compra por el Número de Factura
     *
     * @param billNumber Recibe el Número de Factura de la Compra a Buscar
     * @return Devuelve la Compra Encontrada
     */
    @Override
    public PurchaseResponseDTO getPurchase(Integer billNumber) {

        Optional<PurchaseEntity> purchaseEntitySearch = iPurchaseCRUDRepository.findById(billNumber);

        if (purchaseEntitySearch.isEmpty()) {
            return null;
        }

        return toPurchaseResponseDTOByEntity(purchaseEntitySearch.get());

    }

    /**
     * Guarda una Nueva Compra
     *
     * @param purchaseRequestDTO Recibe la Compra a Guardar
     * @return Devuelve la Factura de la Compra Guardada
     */
    @Override
    public PurchaseBillResponseDTO save(PurchaseRequestDTO purchaseRequestDTO) {

        PurchaseEntity purchaseEntity = iPurchaseMapper.toPurchaseEntity(purchaseRequestDTO);
        purchaseEntity.getCarPurchaseEntities().forEach(carPurchaseEntity -> carPurchaseEntity.setPurchaseEntity(purchaseEntity));
        PurchaseEntity purchaseEntitySave = iPurchaseCRUDRepository.save(purchaseEntity);

        return new PurchaseBillResponseDTO(purchaseEntitySave.getBillNumber());

    }

    /**
     * Convierte una Entidad a un DTO de "Compras"
     *
     * @param purchaseEntity Recibe una Entidad de "Compras"
     * @return Devuelve un DTO de "Compras"
     */
    public PurchaseResponseDTO toPurchaseResponseDTOByEntity(PurchaseEntity purchaseEntity) {

        PurchaseResponseDTO purchaseResponseDTO = new PurchaseResponseDTO();
        purchaseResponseDTO.setBillNumber(purchaseEntity.getBillNumber());
        purchaseResponseDTO.setCustomerCardId(purchaseEntity.getCustomerCardId());
        purchaseResponseDTO.setDate(purchaseEntity.getDate());
        purchaseResponseDTO.setTotal(purchaseEntity.getTotal());
        purchaseResponseDTO.setPaymentMethod(purchaseEntity.getPaymentMethod());

        List<CarPurchaseResponseDTO> carPurchaseResponseDTOList = new ArrayList<>();

        purchaseEntity.getCarPurchaseEntities().forEach(carPurchaseEntity -> {
            String reference = carPurchaseEntity.getCarEntity().getReference();
            Integer quantity = carPurchaseEntity.getQuantity();
            Integer total = carPurchaseEntity.getTotal();
            carPurchaseResponseDTOList.add(new CarPurchaseResponseDTO(reference, quantity, total));
        });

        purchaseResponseDTO.setCarPurchaseResponseDTOs(carPurchaseResponseDTOList);
        return purchaseResponseDTO;

    }

}
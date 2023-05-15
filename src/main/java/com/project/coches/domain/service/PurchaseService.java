package com.project.coches.domain.service;

import com.project.coches.domain.dto.PurchaseBillResponseDTO;
import com.project.coches.domain.dto.PurchaseRequestDTO;
import com.project.coches.domain.dto.PurchaseResponseDTO;
import com.project.coches.domain.repository.IPurchaseRepository;
import com.project.coches.domain.usecase.IPurchaseUseCase;
import com.project.coches.exception.PurchaseNotExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Servicio de "Compras"
 */
@RequiredArgsConstructor
@Service
public class PurchaseService implements IPurchaseUseCase {

    /**
     * Repositorio de "Compras"
     */
    private final IPurchaseRepository iPurchaseRepository;

    /**
     * Obtiene una Lista de Compras
     *
     * @return Devuelve la Lista de las Compras
     */
    @Override
    public List<PurchaseResponseDTO> getAll() {
        return iPurchaseRepository.getAll();
    }

    /**
     * Obtiene una Lista de Compras por la Cédula del Cliente
     *
     * @param customerCardId Recibe la Cédula del Cliente de las Compras a Buscar
     * @return Devuelve la Lista de las Compras Encontradas
     */
    @Override
    public List<PurchaseResponseDTO> getAllByCustomerCardId(String customerCardId) {
        return iPurchaseRepository.getAllByCustomerCardId(customerCardId);
    }

    /**
     * Obtiene una Compra por el Número de Factura
     *
     * @param billNumber Recibe el Número de Factura de la Compra a Buscar
     * @return Devuelve la Compra Encontrada
     */
    @Override
    public PurchaseResponseDTO getPurchase(Integer billNumber) {

        PurchaseResponseDTO purchaseResponseDTO = iPurchaseRepository.getPurchase(billNumber);

        if (purchaseResponseDTO == null) {
            throw new PurchaseNotExistsException();
        }

        return purchaseResponseDTO;

    }

    /**
     * Guarda una Nueva Compra
     *
     * @param purchaseRequestDTO Recibe la Compra a Guardar
     * @return Devuelve la Factura de la Compra Guardada
     */
    @Override
    public PurchaseBillResponseDTO save(PurchaseRequestDTO purchaseRequestDTO) {
        return iPurchaseRepository.save(purchaseRequestDTO);
    }

}
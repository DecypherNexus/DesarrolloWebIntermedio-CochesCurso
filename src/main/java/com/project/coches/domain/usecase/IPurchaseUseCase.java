package com.project.coches.domain.usecase;

import com.project.coches.domain.dto.PurchaseBillResponseDTO;
import com.project.coches.domain.dto.PurchaseRequestDTO;
import com.project.coches.domain.dto.PurchaseResponseDTO;

import java.util.List;

/**
 * Interfaz del Caso de Uso de "Compras"
 */
public interface IPurchaseUseCase {

    /**
     * Obtiene una Lista de Compras
     *
     * @return Devuelve la Lista de las Compras
     */
    List<PurchaseResponseDTO> getAll();

    /**
     * Obtiene una Lista de Compras por la Cédula del Cliente
     *
     * @param customerCardId Recibe la Cédula del Cliente de las Compras a Buscar
     * @return Devuelve la Lista de las Compras Encontradas
     */
    List<PurchaseResponseDTO> getAllByCustomerCardId(String customerCardId);

    /**
     * Obtiene una Compra por el Número de Factura
     *
     * @param billNumber Recibe el Número de Factura de la Compra a Buscar
     * @return Devuelve la Compra Encontrada
     */
    PurchaseResponseDTO getPurchase(Integer billNumber);

    /**
     * Guarda una Nueva Compra
     *
     * @param purchaseRequestDTO Recibe la Compra a Guardar
     * @return Devuelve la Factura de la Compra Guardada
     */
    PurchaseBillResponseDTO save(PurchaseRequestDTO purchaseRequestDTO);

}
package com.project.coches.domain.repository;

import com.project.coches.domain.dto.PurchaseBillResponseDTO;
import com.project.coches.domain.dto.PurchaseRequestDTO;
import com.project.coches.domain.dto.PurchaseResponseDTO;

import java.util.List;

/**
 * Interfaz del Repositorio de "Compras"
 */
public interface IPurchaseRepository {

    /**
     * Obtiene una Lista de Clientes
     *
     * @return Devuelve la Lista de los Clientes
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

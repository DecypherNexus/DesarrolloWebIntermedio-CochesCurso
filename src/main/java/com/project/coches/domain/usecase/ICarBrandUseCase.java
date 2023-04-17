package com.project.coches.domain.usecase;

import com.project.coches.domain.dto.CarBrandDTO;

import java.util.List;
import java.util.Optional;

/**
 * Interfaz del Caso de Uso de "Marca_Coche"
 */
public interface ICarBrandUseCase {

    /**
     * Obtiene una Lista de Marcas de Coches
     *
     * @return Devuelve la Lista de las Marcas de Coches
     */
    List<CarBrandDTO> getAll();

    /**
     * Obtiene una Marca de Coche por el Id
     *
     * @param id Recibe el Id de la Marca de Coche a Buscar
     * @return Devuelve el Optional de la Marca de Coche Encontrada
     */
    Optional<CarBrandDTO> getCarBrand(Integer id);

    /**
     * Guarda una Nueva Marca de Coche
     *
     * @param newCarBrandDTO Recibe la Marca de Coche a Guardar
     * @return Devuelve la Marca de Coche Guardada
     */
    CarBrandDTO save(CarBrandDTO newCarBrandDTO);

    /**
     * Actualiza una Marca de Coche
     *
     * @param updatedCarBrandDTO Recibe la Marca de Coche a Actualizar
     * @return Devuelve la Marca de Coche Actualizada
     */
    Optional<CarBrandDTO> update(CarBrandDTO updatedCarBrandDTO);

    /**
     * Elimina una Marca de Coche por el Id
     *
     * @param id Recibe el Id de la Marca de Coche a Eliminar
     * @return Devuelve un Valor "True" si se Eliminó y "False" si no se Eliminó
     */
    boolean delete(Integer id);

}
package com.project.coches.domain.usecase;

import com.project.coches.domain.dto.CarDTO;

import java.util.List;
import java.util.Optional;

/**
 * Interfaz del Caso de Uso de "Coches"
 */
public interface ICarUseCase {

    /**
     * Obtiene una Lista de Coches
     *
     * @return Devuelve la Lista de los Coches
     */
    List<CarDTO> getAll();

    /**
     * Obtiene una Lista de Coches por el Id de la Marca
     *
     * @param carBrandId Recibe el Id de la Marca de los Coches a Buscar
     * @return Devuelve la Lista de los Coches Encontrados
     */
    List<CarDTO> getAllByCarBrandId(Integer carBrandId);

    /**
     * Obtiene una Lista de Coches por el Precio que sea Menor Que
     *
     * @param price Recibe el Precio de los Coches a Buscar cuyo Precio sea Menor Que
     * @return Devuelve la Lista de los Coches Encontrados
     */
    List<CarDTO> getAllByPriceLessThan(Double price);

    /**
     * Obtiene un Coche por el Código
     *
     * @param carCode Recibe el Código del Coche a Buscar
     * @return Devuelve el Optional del Coche Encontrado
     */
    Optional<CarDTO> getCar(Integer carCode);

    /**
     * Guarda un Nuevo Coche
     *
     * @param newCarDTO Recibe el Coche a Guardar
     * @return Devuelve el Coche Guardado
     */
    CarDTO save(CarDTO newCarDTO);

    /**
     * Actualiza un Coche
     *
     * @param updatedCarDTO Recibe el Coche a Actualizar
     * @return Devuelve el Coche Actualizado
     */
    Optional<CarDTO> update(CarDTO updatedCarDTO);

    /**
     * Elimina un Coche por el Código
     *
     * @param carCode Recibe el Código del Coche a Eliminar
     * @return Devuelve un Valor "True" si se Eliminó y "False" si no se Eliminó
     */
    boolean delete(Integer carCode);

}

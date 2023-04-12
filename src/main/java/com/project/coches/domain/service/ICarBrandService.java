package com.project.coches.domain.service;

import com.project.coches.domain.pojo.CarBrandPojo;

import java.util.List;
import java.util.Optional;

public interface ICarBrandService {

    /**
     * Obtiene una Lista de Marcas de Coches
     * @return Devuelve la Lista de las Marcas de Coches
     */
    List<CarBrandPojo> getAll();

    /**
     * Obtiene una Marca de Coche por el Id
     * @param id Recibe el Id de la Marca de Coche
     * @return Devuelve el Optional de la Marca de Coche Encontrada
     */
    Optional<CarBrandPojo> getCarBrand(Integer id);

    /**
     * Guarda una Nueva Marca de Coche
     * @param newCarBrandPojo Recibe la Marca de Coche a Guardar
     * @return Devuelve la Marca de Coche Guardada
     */
    CarBrandPojo save(CarBrandPojo newCarBrandPojo);

    /**
     * Elimina una Marca de Coche por el Id
     * @param id Recibe el Id de la Marca de Coche a Eliminar
     * @return Devuelve un Valor "True" si se Eliminó y "False" si no se Eliminó
     */
    boolean delete(Integer id);

}

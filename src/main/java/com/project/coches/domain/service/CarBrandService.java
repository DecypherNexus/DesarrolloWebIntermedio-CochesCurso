package com.project.coches.domain.service;

import com.project.coches.domain.pojo.CarBrandPojo;
import com.project.coches.domain.repository.ICarBrandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Servicio de "Marca_Coche"
 */
@RequiredArgsConstructor
@Service
public class CarBrandService implements ICarBrandService {

    /**
     * Repositorio de "Marca_Coche"
     */
    private final ICarBrandRepository iCarBrandRepository;

    /**
     * Obtiene una Lista de Marcas de Coches
     * @return Devuelve la Lista de las Marcas de Coches
     */
    @Override
    public List<CarBrandPojo> getAll() {
        return iCarBrandRepository.getAll();
    }

    /**
     * Obtiene una Marca de Coche por el Id
     * @param id Recibe el Id de la Marca de Coche
     * @return Devuelve el Optional de la Marca de Coche Encontrada
     */
    @Override
    public Optional<CarBrandPojo> getCarBrand(Integer id) {
        return iCarBrandRepository.getCarBrand(id);
    }

    /**
     * Guarda una Nueva Marca de Coche
     * @param newCarBrandPojo Recibe la Marca de Coche a Guardar
     * @return Devuelve la Marca de Coche Guardada
     */
    @Override
    public CarBrandPojo save(CarBrandPojo newCarBrandPojo) {
        return iCarBrandRepository.save(newCarBrandPojo);
    }

    /**
     * Elimina una Marca de Coche por el Id
     * @param id Recibe el Id de la Marca de Coche a Eliminar
     * @return Devuelve un Valor "True" si se Eliminó y "False" si no se Eliminó
     */
    @Override
    public boolean delete(Integer id) {

        try {
            iCarBrandRepository.delete(id);
            return true;
        } catch (Exception exception) {
            return false;
        }

    }

}

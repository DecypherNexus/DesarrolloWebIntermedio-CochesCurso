package com.project.coches.domain.service;

import com.project.coches.domain.dto.CarBrandDTO;
import com.project.coches.domain.repository.ICarBrandRepository;
import com.project.coches.domain.usecase.ICarBrandUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Servicio de "Marca_Coche"
 */
@RequiredArgsConstructor
@Service
public class CarBrandService implements ICarBrandUseCase {

    /**
     * Repositorio de "Marca_Coche"
     */
    private final ICarBrandRepository iCarBrandRepository;

    /**
     * Obtiene una Lista de Marcas de Coches
     *
     * @return Devuelve la Lista de las Marcas de Coches
     */
    @Override
    public List<CarBrandDTO> getAll() {
        return iCarBrandRepository.getAll();
    }

    /**
     * Obtiene una Marca de Coche por el Id
     *
     * @param id Recibe el Id de la Marca de Coche a Buscar
     * @return Devuelve el Optional de la Marca de Coche Encontrada
     */
    @Override
    public Optional<CarBrandDTO> getCarBrand(Integer id) {
        return iCarBrandRepository.getCarBrand(id);
    }

    /**
     * Guarda una Nueva Marca de Coche
     *
     * @param newCarBrandDTO Recibe la Marca de Coche a Guardar
     * @return Devuelve la Marca de Coche Guardada
     */
    @Override
    public CarBrandDTO save(CarBrandDTO newCarBrandDTO) {
        return iCarBrandRepository.save(newCarBrandDTO);
    }

    /**
     * Actualiza una Marca de Coche
     *
     * @param updatedCarBrandDTO Recibe la Marca de Coche a Actualizar
     * @return Devuelve la Marca de Coche Actualizada
     */
    @Override
    public Optional<CarBrandDTO> update(CarBrandDTO updatedCarBrandDTO) {

        if (iCarBrandRepository.getCarBrand(updatedCarBrandDTO.getId()).isEmpty()) {
            return Optional.empty();
        }

        return Optional.of(iCarBrandRepository.save(updatedCarBrandDTO));

    }

    /**
     * Elimina una Marca de Coche por el Id
     *
     * @param id Recibe el Id de la Marca de Coche a Eliminar
     * @return Devuelve un Valor "True" si se Eliminó y "False" si no se Eliminó
     */
    @Override
    public boolean delete(Integer id) {

        if (iCarBrandRepository.getCarBrand(id).isEmpty()) {
            return false;
        }

        iCarBrandRepository.delete(id);
        return true;

    }

}

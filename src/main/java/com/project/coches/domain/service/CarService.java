package com.project.coches.domain.service;

import com.project.coches.domain.dto.CarDTO;
import com.project.coches.domain.repository.ICarRepository;
import com.project.coches.domain.usecase.ICarUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Servicio de "Coches"
 */
@RequiredArgsConstructor
@Service
public class CarService implements ICarUseCase {

    /**
     * Repositorio de "Coches"
     */
    private final ICarRepository iCarRepository;

    /**
     * Obtiene una Lista de Coches
     *
     * @return Devuelve la Lista de los Coches
     */
    @Override
    public List<CarDTO> getAll() {
        return iCarRepository.getAll();
    }

    /**
     * Obtiene una Lista de Coches por el Id de la Marca
     *
     * @param carBrandId Recibe el Id de la Marca de los Coches a Buscar
     * @return Devuelve la Lista de los Coches Encontrados
     */
    @Override
    public List<CarDTO> getAllByCarBrandId(Integer carBrandId) {
        return iCarRepository.getAllByCarBrandId(carBrandId);
    }

    /**
     * Obtiene una Lista de Coches por el Precio que sea Menor Que
     *
     * @param price Recibe el Precio de los Coches a Buscar cuyo Precio sea Menor Que
     * @return Devuelve la Lista de los Coches Encontrados
     */
    @Override
    public List<CarDTO> getAllByPriceLessThan(Double price) {
        return iCarRepository.getAllByPriceLessThan(price);
    }

    /**
     * Obtiene un Coche por el Código
     *
     * @param carCode Recibe el Código del Coche a Buscar
     * @return Devuelve el Optional del Coche Encontrado
     */
    @Override
    public Optional<CarDTO> getCar(Integer carCode) {
        return iCarRepository.getCar(carCode);
    }

    /**
     * Guarda un Nuevo Coche
     *
     * @param newCarDTO Recibe el Coche a Guardar
     * @return Devuelve el Coche Guardado
     */
    @Override
    public CarDTO save(CarDTO newCarDTO) {
        return iCarRepository.save(newCarDTO);
    }

    /**
     * Actualiza un Coche
     *
     * @param updateCarDTO Recibe el Coche a Actualizar
     * @return Devuelve el Coche Actualizado
     */
    @Override
    public Optional<CarDTO> update(CarDTO updateCarDTO) {

        if (iCarRepository.getCar(updateCarDTO.getCarCode()).isEmpty()) {
            return Optional.empty();
        }

        return Optional.of(iCarRepository.save(updateCarDTO));

    }

    /**
     * Elimina un Coche por el Código
     *
     * @param carCode Recibe el Código del Coche a Eliminar
     * @return Devuelve un Valor "True" si se Eliminó y "False" si no se Eliminó
     */
    @Override
    public boolean delete(Integer carCode) {

        if (iCarRepository.getCar(carCode).isEmpty()) {
            return false;
        }

        iCarRepository.delete(carCode);
        return true;

    }

}

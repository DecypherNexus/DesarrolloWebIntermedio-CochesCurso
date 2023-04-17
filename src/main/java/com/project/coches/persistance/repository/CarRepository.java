package com.project.coches.persistance.repository;

import com.project.coches.domain.dto.CarDTO;
import com.project.coches.domain.repository.ICarRepository;
import com.project.coches.persistance.crud.ICarCRUDRepository;
import com.project.coches.persistance.mapper.ICarMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repositorio de "Coches"
 */
@RequiredArgsConstructor
@Repository
public class CarRepository implements ICarRepository {

    /**
     * CRUD de "Coches"
     */
    private final ICarCRUDRepository iCarCRUDRepository;

    /**
     * Mapper de "Coches"
     */
    private final ICarMapper iCarMapper;

    /**
     * Obtiene una Lista de Coches
     *
     * @return Devuelve la Lista de los Coches
     */
    @Override
    public List<CarDTO> getAll() {
        return iCarMapper.toCarDTOs(iCarCRUDRepository.findAll());
    }

    /**
     * Obtiene una Lista de Coches por el Id de la Marca
     *
     * @param carBrandId Recibe el Id de la Marca de los Coches a Buscar
     * @return Devuelve la Lista de los Coches Encontrados
     */
    @Override
    public List<CarDTO> getAllByCarBrandId(Integer carBrandId) {
        return iCarMapper.toCarDTOs(iCarCRUDRepository.findAllByCarBrandId(carBrandId));
    }

    /**
     * Obtiene una Lista de Coches por el Precio que sea Menor Que
     *
     * @param price Recibe el Precio de los Coches a Buscar cuyo Precio sea Menor Que
     * @return Devuelve la Lista de los Coches Encontrados
     */
    @Override
    public List<CarDTO> getAllByPriceLessThan(Double price) {
        return iCarMapper.toCarDTOs(iCarCRUDRepository.findAllByPriceLessThanEqualOrderByPriceAsc(price));
    }

    /**
     * Obtiene un Coche por el Código
     *
     * @param carCode Recibe el Código del Coche a Buscar
     * @return Devuelve el Optional del Coche Encontrado
     */
    @Override
    public Optional<CarDTO> getCar(Integer carCode) {
        return iCarCRUDRepository.findById(carCode)
                .map(iCarMapper::toCarDTO);
    }

    /**
     * Guarda un Nuevo Coche
     *
     * @param newCarDTO Recibe el Coche a Guardar
     * @return Devuelve el Coche Guardado
     */
    @Override
    public CarDTO save(CarDTO newCarDTO) {
        return iCarMapper
                .toCarDTO(iCarCRUDRepository
                        .save(iCarMapper
                                .toCarEntity(newCarDTO)));
    }

    /**
     * Elimina un Coche por el Código
     *
     * @param carCode Recibe el Código del Coche a Eliminar
     */
    @Override
    public void delete(Integer carCode) {
        iCarCRUDRepository.deleteById(carCode);
    }

}

package com.project.coches.persistance.repository;

import com.project.coches.domain.dto.CarBrandDTO;
import com.project.coches.domain.repository.ICarBrandRepository;
import com.project.coches.persistance.crud.ICarBrandCRUDRepository;
import com.project.coches.persistance.mapper.ICarBrandMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repositorio de "Marca_Coche"
 */
@RequiredArgsConstructor
@Repository
public class CarBrandRepository implements ICarBrandRepository {

    /**
     * CRUD de "Marca_Coche"
     */
    private final ICarBrandCRUDRepository iCarBrandCRUDRepository;

    /**
     * Mapper de "Marca_Coche"
     */
    private final ICarBrandMapper iCarBrandMapper;

    /**
     * Obtiene una Lista de Marcas de Coches
     *
     * @return Devuelve la Lista de las Marcas de Coches
     */
    @Override
    public List<CarBrandDTO> getAll() {
        return iCarBrandMapper.toCarBrandDTOs(iCarBrandCRUDRepository.findAll());
    }

    /**
     * Obtiene una Marca de Coche por el Id
     *
     * @param id Recibe el Id de la Marca de Coche
     * @return Devuelve el Optional de la Marca de Coche Encontrada
     */
    @Override
    public Optional<CarBrandDTO> getCarBrand(Integer id) {
        return iCarBrandCRUDRepository.findById(id)
                .map(iCarBrandMapper::toCarBrandDTO);
        // .map(carBrandEntity -> iCarBrandMapper.toCarBrandPojo(carBrandEntity)); -> Función Lambda
        // .map(iCarBrandMapper::toCarBrandPojo); -> Métodod por Referencia
    }

    /**
     * Guarda una Nueva Marca de Coche
     *
     * @param newCarBrandDTO Recibe la Marca de Coche a Guardar
     * @return Devuelve la Marca de Coche Guardada
     */
    @Override
    public CarBrandDTO save(CarBrandDTO newCarBrandDTO) {
        return iCarBrandMapper
                .toCarBrandDTO(iCarBrandCRUDRepository
                        .save(iCarBrandMapper
                                .toCarBrandEntity(newCarBrandDTO)));
    }

    /**
     * Elimina una Marca de Coche por el Id
     *
     * @param id Recibe el Id de la Marca de Coche a Eliminar
     */
    @Override
    public void delete(Integer id) {
        iCarBrandCRUDRepository.deleteById(id);
    }

}

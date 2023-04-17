package com.project.coches.controller;

import com.project.coches.domain.dto.CarDTO;
import com.project.coches.domain.usecase.ICarUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST de "Coches"
 */
@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/cars")
public class CarController {

    /**
     * Caso de Uso de "Cliente"
     */
    private final ICarUseCase iCarUseCase;

    /**
     * Obtiene una Lista de Coches
     *
     * @return Devuelve un Código Http "OK" con la Lista de los Coches
     */
    @GetMapping()
    public ResponseEntity<List<CarDTO>> getAll() {
        return ResponseEntity.ok(iCarUseCase.getAll());
    }

    /**
     * Obtiene una Lista de Coches por el Id de la Marca
     *
     * @param carBrandId Recibe el Id de la Marca de los Coches a Buscar
     * @return Devuelve un Código Http "OK" con la Lista de los Coches
     */
    @GetMapping(path = "/car-brand/{carBrandId}")
    public ResponseEntity<List<CarDTO>> getAllByCarBrandId(@PathVariable Integer carBrandId) {
        return ResponseEntity.ok(iCarUseCase.getAllByCarBrandId(carBrandId));
    }

    /**
     * Obtiene una Lista de Coches por el Precio que sea Menor Que
     *
     * @param price Recibe el Precio de los Coches a Buscar cuyo Precio sea Menor Que
     * @return Devuelve un Código Http "OK" con la Lista de los Coches
     */
    @GetMapping(path = "/price/{price}")
    public ResponseEntity<List<CarDTO>> getAllByPriceLessThan(@PathVariable Double price) {
        return ResponseEntity.ok(iCarUseCase.getAllByPriceLessThan(price));
    }

    /**
     * Obtiene un Coche por el Código
     *
     * @param carCode Recibe el Código del Coche a Buscar
     * @return Devuelve un Código Http "OK" en el caso de que el Coche haya sido encontrado o un Código Http "NOT FOUND" en el caso contrario
     */
    @GetMapping(path = "/{carCode}")
    public ResponseEntity<CarDTO> getCar(@PathVariable Integer carCode) {
        return ResponseEntity.of(iCarUseCase.getCar(carCode));
    }

    /**
     * Guarda un Nuevo Coche
     *
     * @param newCarDTO Recibe el Coche a Guardar
     * @return Devuelve un Código Http "CREATED" en el caso de que el Coche haya sido guardado o un Código Http "BAD REQUEST" en el caso contrario
     */
    @PostMapping()
    public ResponseEntity<CarDTO> save(@RequestBody CarDTO newCarDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(iCarUseCase.save(newCarDTO));
    }

    /**
     * Actualiza un Coche
     *
     * @param updatedCarDTO Recibe el Coche a Actualizar
     * @return Devuelve un Código Http "OK" en el caso de que el Coche haya sido actualizado o un Código Http "BAD REQUEST" en el caso contrario
     */
    @PatchMapping()
    public ResponseEntity<CarDTO> update(@RequestBody CarDTO updatedCarDTO) {
        return ResponseEntity.of(iCarUseCase.update(updatedCarDTO));
    }

    /**
     * Elimina un Coche por el Código
     *
     * @param carCode Recibe el Código del Coche a Eliminar
     * @return Devuelve un Código Http "OK" en el caso de que el Coche haya sido eliminado o un Código Http "NOT FOUND" en el caso contrario
     */
    @DeleteMapping(path = "/{carCode}")
    public ResponseEntity<Boolean> delete(@PathVariable Integer carCode) {
        return new ResponseEntity<>(iCarUseCase.delete(carCode) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

}

package com.project.coches.controller;

import com.project.coches.domain.dto.CarBrandDTO;
import com.project.coches.domain.usecase.ICarBrandUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST de "Marca_Coche"
 */
@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/car-brands")
public class CarBrandController {

    /**
     * Caso de Uso de "Marca_Coche"
     */
    private final ICarBrandUseCase iCarBrandUseCase;

    /**
     * Obtiene una Lista de Marcas de Coches
     *
     * @return Devuelve un Código Http "OK" con la Lista de las Marcas de Coches
     */
    @GetMapping()
    public ResponseEntity<List<CarBrandDTO>> getAll() {
        return ResponseEntity.ok(iCarBrandUseCase.getAll());
        // return ResponseEntity.status(HttpStatus.OK).body(iCarBrandUseCase.getAll()); -> Notación Alternativa para Crear "ResponseEntity"
        // return new ResponseEntity<>(iCarBrandUseCase.getAll(), HttpStatus.OK); -> Notación Alternativa para Crear "ResponseEntity"
    }

    /**
     * Obtiene una Marca de Coche por el Id
     *
     * @param id Recibe el Id de la Marca de Coche a Buscar
     * @return Devuelve un Código Http "OK" en el caso de que la Marca de Coche haya sido encontrada o un Código Http "NOT FOUND" en el caso contrario
     */
    @GetMapping(path = "/{id}")
    public ResponseEntity<CarBrandDTO> getCarBrand(@PathVariable Integer id) {
        return ResponseEntity.of(iCarBrandUseCase.getCarBrand(id));
    }

    /**
     * Guarda una Nueva Marca de Coche
     *
     * @param newCarBrandDTO Recibe la Marca de Coche a Guardar
     * @return Devuelve un Código Http "CREATED" en el caso de que la Marca de Coche haya sido guardada o un Código Http "BAD REQUEST" en el caso contrario
     */
    @PostMapping()
    public ResponseEntity<CarBrandDTO> save(@RequestBody CarBrandDTO newCarBrandDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(iCarBrandUseCase.save(newCarBrandDTO));
    }

    /**
     * Actualiza una Marca de Coche
     *
     * @param updatedCarBrandDTO Recibe la Marca de Coche a Actualizar
     * @return Devuelve un Código Http "OK" en el caso de que la Marca de Coche haya sido actualizada o un Código Http "BAD REQUEST" en el caso contrario
     */
    @PatchMapping()
    public ResponseEntity<CarBrandDTO> update(@RequestBody CarBrandDTO updatedCarBrandDTO) {
        return ResponseEntity.of(iCarBrandUseCase.update(updatedCarBrandDTO));
    }

    /**
     * Elimina una Marca de Coche por el Id
     *
     * @param id Recibe el Id de la Marca de Coche a Eliminar
     * @return Devuelve un Código Http "OK" en el caso de que la Marca de Coche haya sido eliminada o un Código Http "NOT FOUND" en el caso contrario
     */
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Integer id) {
        return new ResponseEntity<>(iCarBrandUseCase.delete(id) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

}

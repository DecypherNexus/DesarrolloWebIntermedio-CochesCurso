package com.project.coches.controller;

import com.project.coches.domain.pojo.CarBrandPojo;
import com.project.coches.domain.service.ICarBrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Controlador REST de "Marca_Coche"
 */
@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/marcas-coches")
public class CarBrandController {

    /**
     * Servicio de "Marca_Coche"
     */
    private final ICarBrandService iCarBrandService;

    /**
     * Obtiene una Lista de Marcas de Coches
     * @return Devuelve un Código Http "OK" con la Lista de las Marcas de Coches
     */
    @GetMapping()
    public ResponseEntity<List<CarBrandPojo>> getAll() {
        return ResponseEntity.ok(iCarBrandService.getAll());
        // return ResponseEntity.status(HttpStatus.OK).body(iCarBrandService.getAll()); -> Notación Alternativa para Crear "ResponseEntity"
        // return new ResponseEntity<>(iCarBrandService.getAll(), HttpStatus.OK); -> Notación Alternativa para Crear "ResponseEntity"
    }

    /**
     * Obtiene una Marca de Coche por el Id
     * @param id Recibe el Id de la Marca de Coche
     * @return Devuelve un Código Http "OK" en el caso de que la Marca de Coche haya sido encontrada o un Código Http "NOT FOUND" en el caso contrario
     */
    @GetMapping(path = "/{id}")
    public ResponseEntity<CarBrandPojo> getCarBrand(@PathVariable Integer id) {
        return ResponseEntity.of(iCarBrandService.getCarBrand(id));
    }

    /**
     * Guarda una Nueva Marca de Coche
     * @param newCarBrandPojo Recibe la Marca de Coche a Guardar
     * @return Devuelve un Código Http "CREATED" en el caso de que la Marca de Coche haya sido guardada o un Código Http "BAD REQUEST" en el caso contrario
     */
    @PostMapping()
    public ResponseEntity<CarBrandPojo> save(@RequestBody CarBrandPojo newCarBrandPojo) {
        return ResponseEntity.status(HttpStatus.CREATED).body(iCarBrandService.save(newCarBrandPojo));
    }

    /**
     * Actualiza una Marca de Coche
     * @param updatedCarBrandPojo Recibe la Marca de Coche a Actualizar
     * @return Devuelve un Código Http "OK" en el caso de que la Marca de Coche haya sido actualizada o un Código Http "BAD REQUEST" en el caso contrario
     */
    @PatchMapping()
    public ResponseEntity<CarBrandPojo> update(@RequestBody CarBrandPojo updatedCarBrandPojo) {
        return ResponseEntity.of(iCarBrandService.update(updatedCarBrandPojo));
    }

    /**
     * Elimina una Marca de Coche por el Id
     * @param id Recibe el Id de la Marca de Coche a Eliminar
     * @return Devuelve un Código Http "OK" en el caso de que la Marca de Coche haya sido eliminada o un Código Http "NOT FOUND" en el caso contrario
     */
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Integer id) {
        return new ResponseEntity<>(iCarBrandService.delete(id) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

}

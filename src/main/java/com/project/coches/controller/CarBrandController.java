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

    @GetMapping
    public ResponseEntity<List<CarBrandPojo>> getAll() {
        return ResponseEntity.ok(iCarBrandService.getAll());
        // return ResponseEntity.status(HttpStatus.OK).body(iCarBrandService.getAll()); -> Notación Alternativa para Crear "ResponseEntity"
        // return new ResponseEntity<>(iCarBrandService.getAll(), HttpStatus.OK); -> Notación Alternativa para Crear "ResponseEntity"
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<CarBrandPojo> getCarBrand(@PathVariable Integer id) {
        return ResponseEntity.of(iCarBrandService.getCarBrand(id));
    }

    @PostMapping
    public ResponseEntity<CarBrandPojo> save(@RequestBody CarBrandPojo newCarBrandPojo) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(iCarBrandService.save(newCarBrandPojo));
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

}

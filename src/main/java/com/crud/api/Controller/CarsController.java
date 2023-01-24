package com.crud.api.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.api.Model.CarsModel;
import com.crud.api.Repository.CarsRepository;
import com.crud.api.dto.CarsDTO;

import jakarta.validation.Valid;

import java.util.*;

@RestController
@RequestMapping("/api/cars")
public class CarsController {

    @Autowired
    private CarsRepository repository;

    @GetMapping
    public List<CarsModel> listAll() {
        return repository.findAll();
    }

    @PutMapping("{id}")
    public void update(@PathVariable Long id, @RequestBody @Valid CarsDTO req) {
        repository.findById(id).map(car -> {
            car.setModelo(req.modelo());
            car.setFabricante(req.fabricante());
            car.setDataFabricacao(req.dataFabricacao());
            car.setValor(req.valor());
            car.setAnoModelo(req.anoModelo());

            return repository.save(car);
        });
    }

    @PostMapping
    public void create(@RequestBody @Valid CarsDTO req) {

        repository.save(new CarsModel(req));

    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}

package com.crud.api.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.api.Model.CarsModel;

public interface CarsRepository extends JpaRepository<CarsModel, Long> {

}

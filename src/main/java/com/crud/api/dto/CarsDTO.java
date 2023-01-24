package com.crud.api.dto;

public record CarsDTO(
                String modelo,
                String fabricante,
                String dataFabricacao,
                Double valor,
                Integer anoModelo) {

}

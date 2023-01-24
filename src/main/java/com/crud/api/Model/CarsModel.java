package com.crud.api.Model;

import com.crud.api.dto.CarsDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class CarsModel {

    public CarsModel(CarsDTO data) {
        this.modelo = data.modelo();
        this.fabricante = data.fabricante();
        this.dataFabricacao = data.dataFabricacao();
        this.valor = data.valor();
        this.anoModelo = data.anoModelo();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 100, nullable = false)
    private String modelo;

    @Column(length = 100, nullable = false)
    private String fabricante;

    @Column(length = 50, nullable = false)
    private String dataFabricacao;

    @Column(length = 100, nullable = false)
    private Double valor;

    @Column(length = 50, nullable = false)
    private Integer anoModelo;

}

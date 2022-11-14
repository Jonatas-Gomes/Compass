package com.compass.api.controller.dto;

import com.compass.api.modelo.Estado;
import com.compass.api.modelo.Regiao;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

public class EstadoDto {

    private Long id;
    private String nome;
    private String nomeRegiao;
    private String capital;
    private Long populacao;
    private Long area;

    public EstadoDto(Estado estado) {
        this.id = estado.getId();
        this.nome = estado.getNome();
        this.capital = estado.getCapital();
        this.nomeRegiao = estado.getRegiao().getNome();
        this.capital = estado.getCapital();
        this.populacao = estado.getPopulacao();
        this.area = estado.getArea();
    }

    public static Page<EstadoDto> converte(Page<Estado> estados) {
        return estados.map(EstadoDto::new);
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getRegiao() {
        return nomeRegiao;
    }

    public String getCapital() {
        return capital;
    }

    public Long getPopulacao() {
        return populacao;
    }

    public Long getArea() {
        return area;
    }
}

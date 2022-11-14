package com.compass.api.controller.dto;

import com.compass.api.modelo.Estado;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

public class EstadoSocioEconomicDto {
    private Long id;
    private String nome;
    private String nomeRegiao;

    private Long populacao;
    private double pib;
    private double idh;
    private double rendaPerCapita;
    private double taxaDesemprego;
    private double taxaDeMortalidadeInfantil;

    public EstadoSocioEconomicDto(Estado estado) {
        this.id = estado.getId();
        this.nome = estado.getNome();
        this.nomeRegiao = estado.getRegiao().getNome();
        this.populacao = estado.getPopulacao();
        this.pib = estado.getPib();
        this.idh= estado.getIdh();
        this.rendaPerCapita = estado.getRendaPerCapita();
        this.taxaDesemprego = estado.getTaxaDesemprego();
        this.taxaDeMortalidadeInfantil = estado.getTaxaDeMortalidadeInfantil();
    }
    public static Page<EstadoSocioEconomicDto> converte(Page<Estado> estados) {
        return estados.map(EstadoSocioEconomicDto::new);
    }


    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getNomeRegiao() {
        return nomeRegiao;
    }

    public Long getPopulacao() {
        return populacao;
    }

    public double getPib() {
        return pib;
    }

    public double getIdh() {
        return idh;
    }

    public double getRendaPerCapita() {
        return rendaPerCapita;
    }

    public double getTaxaDesemprego() {
        return taxaDesemprego;
    }

    public double getTaxaDeMortalidadeInfantil() {
        return taxaDeMortalidadeInfantil;
    }
}

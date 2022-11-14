package com.compass.api.controller.form;

import com.compass.api.modelo.Estado;
import com.compass.api.repository.EstadoRepository;

import javax.validation.constraints.*;

public class AtualizacaoEstadoForm {

    private Long Populacao;

    private double pib;
    @Max(1)
    private double idh;

    private double rendaPerCapita;
    @Max(1)
    private double taxaDesemprego;
    @Max(1)
    private double taxaDeMortalidadeInfantil;

    public Long getPopulacao() {
        return Populacao;
    }

    public void setPopulacao(Long populacao) {
        Populacao = populacao;
    }

    public double getPib() {
        return pib;
    }

    public void setPib(double pib) {
        this.pib = pib;
    }

    public double getIdh() {
        return idh;
    }

    public void setIdh(double idh) {
        this.idh = idh;
    }

    public double getRendaPerCapita() {
        return rendaPerCapita;
    }

    public void setRendaPerCapita(double rendaPerCapita) {
        this.rendaPerCapita = rendaPerCapita;
    }

    public double getTaxaDesemprego() {
        return taxaDesemprego;
    }

    public void setTaxaDesemprego(double taxaDesemprego) {
        this.taxaDesemprego = taxaDesemprego;
    }

    public double getTaxaDeMortalidadeInfantil() {
        return taxaDeMortalidadeInfantil;
    }

    public void setTaxaDeMortalidadeInfantil(double taxaDeMortalidadeInfantil) {
        this.taxaDeMortalidadeInfantil = taxaDeMortalidadeInfantil;
    }

    public Estado atualizar(Long id, EstadoRepository estadoRepository) {
        Estado estado = estadoRepository.getReferenceById(id);
        estado.setPopulacao(this.Populacao);
        estado.setPib(this.pib);
        estado.setIdh(this.idh);
        estado.setRendaPerCapita(this.rendaPerCapita);
        estado.setTaxaDesemprego(this.taxaDesemprego);
        estado.setTaxaDeMortalidadeInfantil(this.taxaDeMortalidadeInfantil);
        return estado;
    }
}

package com.compass.api.controller.form;

import com.compass.api.modelo.Estado;
import com.compass.api.modelo.Regiao;
import com.compass.api.repository.EstadoRepository;
import com.compass.api.repository.RegiaoRepository;
import org.apache.commons.text.WordUtils;
import org.hibernate.validator.constraints.Length;

import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class EstadoForm {
    private String nome;
    @NotEmpty
    @NotNull
    @Length(min = 3)
    @Pattern(regexp = "^(?i)(Norte|Nordeste|Sul|Sudeste|Centro-Oeste|)$")
    private String nomeRegiao;
    private String capital;
    private Long populacao;
    private Long area;

    private double pib;
    private double idh;
    private double rendaPerCapita;
    private double taxaDesemprego;
    private double taxaDeMortalidadeInfantil;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeRegiao() {
        return nomeRegiao;
    }

    public void setNomeRegiao(String nomeRegiao) {
        String nomeRegiaoFormatado = WordUtils.capitalizeFully(nomeRegiao, '-'); // Formata a string recebida, capitalizando iniciais.
        this.nomeRegiao = nomeRegiaoFormatado;

    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public Long getPopulacao() {
        return populacao;
    }

    public void setPopulacao(Long populacao) {
        this.populacao = populacao;
    }

    public Long getArea() {
        return area;
    }

    public void setArea(Long area) {
        this.area = area;
    }

    public double getPib() {
        return pib;
    }

    public void setPib(Double pib) {
        this.pib = pib;
    }

    public double getIdh() {
        return idh;
    }

    public void setIdh(Double idh) {
        this.idh = idh;
    }

    public double getRendaPerCapita() {
        return rendaPerCapita;
    }

    public void setRendaPerCapita(Double rendaPerCapita) {
        this.rendaPerCapita = rendaPerCapita;
    }

    public double getTaxaDesemprego() {
        return taxaDesemprego;
    }

    public void setTaxaDesemprego(Double taxaDesemprego) {
        this.taxaDesemprego = taxaDesemprego;
    }

    public double getTaxaDeMortalidadeInfantil() {
        return taxaDeMortalidadeInfantil;
    }

    public void setTaxaDeMortalidadeInfantil(Double taxaDeMortalidadeInfantil) {
        this.taxaDeMortalidadeInfantil = taxaDeMortalidadeInfantil;
    }

    public Estado converte(RegiaoRepository regiaoRepository) {
        if(regiaoRepository.findByNome(nomeRegiao) == null){ // Se a região não existir no BD e for uma região válida
            regiaoRepository.save(new Regiao(nomeRegiao));
        }
        Regiao regiao = regiaoRepository.findByNome(nomeRegiao);
        return new Estado(nome, regiao,capital,populacao, area,pib,idh,rendaPerCapita,taxaDesemprego,taxaDeMortalidadeInfantil);
    }
}

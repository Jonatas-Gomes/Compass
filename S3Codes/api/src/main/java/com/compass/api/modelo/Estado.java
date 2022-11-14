package com.compass.api.modelo;

import javax.persistence.*;

@Entity
public class Estado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @ManyToOne
    private Regiao regiao;
    private String capital;
    private Long populacao;
    private Long area;
    private double pib;
    private double idh;
    @Column(name="renda_per_capita")
    private double rendaPerCapita;
    @Column(name="taxa_desemprego")
    private double taxaDesemprego;
    @Column(name="taxa_mortalidade_infantil")
    private double taxaDeMortalidadeInfantil;

    public Estado(String nome, Regiao regiao, String capital, Long populacao, Long area, double pib, double idh, double rendaPerCapita, double taxaDesemprego, double taxaDeMortalidadeInfantil) {
        this.nome = nome;
        this.regiao = regiao;
        this.capital = capital;
        this.populacao = populacao;
        this.area = area;
        this.pib = pib;
        this.idh = idh;
        this.rendaPerCapita = rendaPerCapita;
        this.taxaDesemprego = taxaDesemprego;
        this.taxaDeMortalidadeInfantil = taxaDeMortalidadeInfantil;
    }

    public Estado(String nome, Regiao regiao, String capital) {
        this.nome = nome;
        this.regiao = regiao;
        this.capital = capital;
    }


    public Estado(String nome, Regiao regiao, String capital, Long populacao, Long area) {
        this.nome = nome;
        this.regiao = regiao;
        this.capital = capital;
        this.populacao = populacao;
        this.area = area;
    }

    public Estado() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Regiao getRegiao() {
        return regiao;
    }

    public void setRegiao(Regiao regiao) {
        this.regiao = regiao;
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
    public String getNomeRegiao(){
        return this.regiao.getNome();
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
}

package com.compass.api.modelo;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Regiao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    public Regiao(String nome) {
        this.nome = nome;
    }

    public Regiao() {

    }
    @Override
    public String toString(){
        return this.nome;
    }

    public String getNome() {
        return this.nome;
    }

    public Long getId() {
        return id;
    }
}


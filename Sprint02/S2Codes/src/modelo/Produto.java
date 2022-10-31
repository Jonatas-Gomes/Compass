package modelo;

import java.util.ArrayList;
import java.util.List;
public class Produto {
    private Integer id;
    private String nome;
    private String descricao;
    private Integer quantidade;
    private Double preco;
    private List <Produto> produtos  = new ArrayList<Produto>();

    public Produto(String nome, String descricao, Integer quantidade, double preco){
        this.nome = nome;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return  this.nome;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public Double getPreco() {
        return preco;
    }


}

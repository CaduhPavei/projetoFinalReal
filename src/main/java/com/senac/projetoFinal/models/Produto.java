package com.senac.projetoFinal.models;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.swing.*;
import java.time.LocalDate;

@Entity
public class Produto extends EntityId{
    @Column(name="quantidade")
    private Integer quantidade;
    @Column(name="marca")
    private String marca;
    @Column(name="validade")
    private LocalDate validade;
    @Column(name="nome")
    private String nome;
    @Column(name="preco_compra")
    private Double precoCompra;
    @Column(name="preco_venda")
    private Double precoVenda;

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public LocalDate getValidade() {
        return validade;
    }

    public void setValidade(LocalDate validade) {
        this.validade = validade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPrecoCompra() {
        return precoCompra;
    }

    public void setPrecoCompra(Double precoCompra) {
        this.precoCompra = precoCompra;
    }

    public Double getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(Double precoVenda) {
        this.precoVenda = precoVenda;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "quantidade=" + quantidade +
                ", marca='" + marca + '\'' +
                ", validade=" + validade +
                ", nome='" + nome + '\'' +
                ", precoCompra=" + precoCompra +
                ", precoVenda=" + precoVenda +
                '}';
    }
}

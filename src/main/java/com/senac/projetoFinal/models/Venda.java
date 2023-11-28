package com.senac.projetoFinal.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
public class Venda extends EntityId{

    @ManyToOne
    @JoinColumn(name= "id_produto")
    private Produto produto;
    @Column(name = "data_venda")
    private LocalDate dataVenda;
    @Column(name = "observacao")
    private String observacao;
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public LocalDate getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(LocalDate dataVenda) {
        this.dataVenda = dataVenda;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Venda{" +
                "dataVenda=" + dataVenda +
                ", observacao='" + observacao + '\'' +
                ", cliente=" + cliente +
                '}';
    }
}

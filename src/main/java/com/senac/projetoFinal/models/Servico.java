package com.senac.projetoFinal.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Servico extends EntityId{
    @Column(name="tipo_servico")
    private String tipoServico;
    @Column(name="descricao_servico")
    private String descricaoServico;
    @Column(name="valor")
    private Double valor;
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    public String getTipoServico() {
        return tipoServico;
    }

    public void setTipoServico(String tipoServico) {
        this.tipoServico = tipoServico;
    }

    public String getDescricaoServico() {
        return descricaoServico;
    }

    public void setDescricaoServico(String descricaoServico) {
        this.descricaoServico = descricaoServico;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = this.cliente;
    }

    @Override
    public String toString() {
        return "Servico{" +
                "tipoServico='" + tipoServico + '\'' +
                ", descricaoServico='" + descricaoServico + '\'' +
                ", valor=" + valor +
                ", cliente=" + cliente +
                '}';
    }
}

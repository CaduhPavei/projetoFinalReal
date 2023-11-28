package com.senac.projetoFinal.models;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Barbeiro extends Pessoa{

    @Column(name = "cnpj")
    private String cnpj;
    @Column(name="comissao",nullable = false)
    private Double comissao;
    @Column(name="descricao_barbeiro",nullable = false)
    private String descricaoBarbeiro;

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public Double getComissao() {
        return comissao;
    }

    public void setComissao(Double comissao) {
        this.comissao = comissao;
    }

    public String getDescricaoBarbeiro() {
        return descricaoBarbeiro;
    }

    public void setDescricaoBarbeiro(String descricaoBarbeiro) {
        this.descricaoBarbeiro = descricaoBarbeiro;
    }

    @Override
    public String toString() {
        return "Barbeiro{" +
                "cnpj='" + cnpj + '\'' +
                ", comissao=" + comissao +
                ", descricaoBarbeiro='" + descricaoBarbeiro + '\'' +
                '}';
    }
}

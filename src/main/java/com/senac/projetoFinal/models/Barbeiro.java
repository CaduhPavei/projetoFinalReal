package com.senac.projetoFinal.models;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Barbeiro extends Pessoa{

    @Column(name="comissao",nullable = false)
    private Double comissao;
    @Column(name="descricao_barbeiro",nullable = false)
    private String descricaoBarbeiro;
}

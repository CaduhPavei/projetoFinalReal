package com.senac.projetoFinal.models;

import javax.persistence.Column;

public class Servico extends EntityId{
    @Column(name="tipo_servico")
    private String tipoServico;
    @Column(name="descricao_servico")
    private String descricaoServico;
    @Column(name="valor")
    private Double valor;
}

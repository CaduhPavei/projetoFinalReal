package com.senac.projetoFinal.models;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Cliente extends Pessoa{
    @Column(name="cpf",nullable = false)
    private String cpf;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "cpf='" + cpf + '\'' +
                '}';
    }
}

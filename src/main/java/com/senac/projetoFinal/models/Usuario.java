package com.senac.projetoFinal.models;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity

public class Usuario extends Pessoa{

    @Column(name = "nome_usuario", nullable = false)
    private String nomeUsuario;
    @Column(name = "password", nullable = false)
    private String password;
    @Column (name = "tipo", nullable = false)
    private String tipo;

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nomeUsuario='" + nomeUsuario + '\'' +
                ", password='" + password + '\'' +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}
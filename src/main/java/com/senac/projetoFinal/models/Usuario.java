package com.senac.projetoFinal.models;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Usuario extends EntityId{

    @Column(name = "nome_usuario")
    private String nomeUsuario;
    @Column(name = "senha")
    private String senha;
    @Column (name = "tipo")
    private String tipo;
    @Column (name = "email")
    private String email;

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nomeUsuario='" + nomeUsuario + '\'' +
                ", senha='" + senha + '\'' +
                ", tipo='" + tipo + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

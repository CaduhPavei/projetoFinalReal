package com.senac.projetoFinal.models;

import javax.persistence.*;
import java.time.LocalDate;

@MappedSuperclass
public class Pessoa extends EntityId{

    @Column(name="nome")
    private String nome;
    @Column(name="endereco")
    private String endereco;
    @Column(name="data_nascimento")
    private LocalDate dataNascimento;
    @Column(name="email")
    private String email;


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String contato) {
        this.email = contato;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", endereco='" + endereco + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", email='" + email + '\'' +
                '}';
    }
}

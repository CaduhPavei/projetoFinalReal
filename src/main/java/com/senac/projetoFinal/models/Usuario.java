package com.senac.projetoFinal.models;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity

public class Usuario extends Pessoa{
    @Column(name = "nome_usuario", nullable = false)
    private String username;
    @Column(name = "password", nullable = false)
    private String password;
    @Column (name = "tipo", nullable = false)
    private String tipo;
    @Column (name = "email_usuario", nullable = false)
    private String useremail;

    public String getUseremail() {
        return useremail;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", tipo='" + tipo + '\'' +
                ", useremail='" + useremail + '\'' +
                '}';
    }
}

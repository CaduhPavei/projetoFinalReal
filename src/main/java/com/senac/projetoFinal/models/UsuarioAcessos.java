package com.senac.projetoFinal.models;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class UsuarioAcessos extends EntityId{

    @OneToOne
    @JoinColumn(name = "user_id")
    private Usuario user;
    @Column(name = "data_acesso")
    private LocalDate dataAcesso;
    @Column(name = "tipo_chamada")
    private String tipoChamada;

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    public LocalDate getDataAcesso() {
        return dataAcesso;
    }

    public void setDataAcesso(LocalDate dataAcesso) {
        this.dataAcesso = dataAcesso;
    }

    public String getTipoChamada() {
        return tipoChamada;
    }

    public void setTipoChamada(String tipoChamada) {
        this.tipoChamada = tipoChamada;
    }

    @Override
    public String toString() {
        return "UsuarioAcessos{" +
                "user=" + user +
                ", dataAcesso=" + dataAcesso +
                ", tipoChamada='" + tipoChamada + '\'' +
                '}';
    }
}

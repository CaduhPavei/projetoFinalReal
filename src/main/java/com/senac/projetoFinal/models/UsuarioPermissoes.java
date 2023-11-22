package com.senac.projetoFinal.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;

@Entity
public class UsuarioPermissoes extends EntityId {
    //to many
    @JoinColumn(name = "user_id")
    private Usuario user;
    @Column(name = "rotina")
    private String rotina;
    @Column(name = "nivel")
    private String nivel;

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    public String getRotina() {
        return rotina;
    }

    public void setRotina(String rotina) {
        this.rotina = rotina;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    @Override
    public String toString() {
        return "UsuarioPermissoes{" +
                "user=" + user +
                ", rotina='" + rotina + '\'' +
                ", nivel='" + nivel + '\'' +
                '}';
    }
}

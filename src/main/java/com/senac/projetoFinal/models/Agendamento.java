package com.senac.projetoFinal.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import java.time.LocalDate;

@Entity
public class Agendamento extends EntityId{

    //@many to one
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
    @Column(name="data",nullable = true)
    private LocalDate data;
    @Column(name="hora",nullable = true)
    private LocalDate hora;
    @Column(name="reservado",nullable = true)
    private Boolean reservado;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalDate getHora() {
        return hora;
    }

    public void setHora(LocalDate hora) {
        this.hora = hora;
    }

    public Boolean getReservado() {
        return reservado;
    }

    public void setReservado(Boolean reservado) {
        this.reservado = reservado;
    }

    @Override
    public String toString() {
        return "Agendamento{" +
                "usuario=" + usuario +
                ", data=" + data +
                ", hora=" + hora +
                ", reservado=" + reservado +
                '}';
    }
}

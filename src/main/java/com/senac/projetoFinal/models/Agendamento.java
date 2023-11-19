package com.senac.projetoFinal.models;

import javax.persistence.Column;
import java.time.LocalDate;

public class Agendamento extends EntityId{
    @Column(name="data",nullable = true)
    private LocalDate data;
    @Column(name="hora",nullable = true)
    private LocalDate hora;
    @Column(name="reservado",nullable = true)
    private Boolean reservado;

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
                "data=" + data +
                ", hora=" + hora +
                ", reservado=" + reservado +
                '}';
    }
}

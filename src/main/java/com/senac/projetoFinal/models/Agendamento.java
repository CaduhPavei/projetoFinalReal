package com.senac.projetoFinal.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class Agendamento extends EntityId{

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
    @ManyToOne
    @JoinColumn(name = "barbeiro_id")
    private Barbeiro barbeiro;
    @Column(name="data",nullable = true)
    private LocalDate data;
    @Column(name="hora",nullable = true)
    private LocalTime hora;
    @Column(name="reservado",nullable = true)
    private Boolean reservado;


    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Barbeiro getBarbeiro() {
        return barbeiro;
    }

    public void setBarbeiro(Barbeiro barbeiro) {
        this.barbeiro = barbeiro;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
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
                "cliente=" + cliente +
                ", barbeiro=" + barbeiro +
                ", data=" + data +
                ", hora=" + hora +
                ", reservado=" + reservado +
                '}';
    }
}

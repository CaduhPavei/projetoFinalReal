package com.senac.projetoFinal.models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Pedido {
    private Boolean entrega;
    private Integer quantidade;
    private Double valorTotal;
    private LocalDate dataPedido;
}

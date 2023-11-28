package com.senac.projetoFinal.repository;

import com.senac.projetoFinal.models.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;

@Repository
public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {
    public Agendamento findByData(LocalDate data);
    public Agendamento findByHora(LocalTime hora);
}

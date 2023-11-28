package com.senac.projetoFinal.repository;

import com.senac.projetoFinal.models.Barbeiro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BarbeiroRepository extends JpaRepository<Barbeiro, Long> {
    public Barbeiro findByCnpj(String cnpj);
}

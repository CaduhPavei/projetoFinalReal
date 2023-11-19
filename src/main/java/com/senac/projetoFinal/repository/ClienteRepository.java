package com.senac.projetoFinal.repository;

import com.senac.projetoFinal.models.Cliente;
import com.senac.projetoFinal.models.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    public Cliente findByCpf(String cpf);
}

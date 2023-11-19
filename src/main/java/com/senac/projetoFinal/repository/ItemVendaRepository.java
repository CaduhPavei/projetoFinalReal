package com.senac.projetoFinal.repository;

import com.senac.projetoFinal.models.ItemVenda;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemVendaRepository extends JpaRepository<ItemVenda, Long> {

    public List<ItemVenda> findAllByVendaId(Long id);

}

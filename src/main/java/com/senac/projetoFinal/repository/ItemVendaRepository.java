package com.senac.projetoFinal.repository;

import com.senac.projetoFinal.models.ItemVenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemVendaRepository extends JpaRepository<ItemVenda, Long> {
    public List<ItemVenda> findAllByVendaId(Long id);
    public ItemVenda findByQuantidade(Integer quantidade);
}

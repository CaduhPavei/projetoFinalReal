package com.senac.projetoFinal.service;

import com.senac.projetoFinal.enterprise.ValidationException;
import com.senac.projetoFinal.models.ItemVenda;
import com.senac.projetoFinal.models.Produto;
import com.senac.projetoFinal.repository.ItemVendaRepository;
import com.senac.projetoFinal.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Optional;

@Service
public class ItemVendaService {
    @Autowired
    private ItemVendaRepository repository;

    @Autowired
    private ProdutoRepository produtoRepository;


    public void subtraiEstoque(Long itemId, Integer qtd){
        Optional<ItemVenda> optional= repository.findById(itemId);

        if (optional.isPresent()){
            Optional<Produto> byId = produtoRepository.findById(optional.get().getProduto().getId());

            if(byId.isPresent()){
                Integer quantidade = byId.get().getQuantidade();
                if(quantidade>=qtd) {
                    Integer novaQuantidade = quantidade - qtd;
                    Produto produto = byId.get();
                    produto.setQuantidade(novaQuantidade);
                    produtoRepository.save(produto);
                }else{
                    throw new ValidationException("Quantidade solicita indisponível! Apenas "+quantidade+" em estoque.");
                }
            }
        }
    }

    public ItemVenda salvar(ItemVenda entity) {

        return repository.save(entity);
    }
    public List<ItemVenda> buscaTodosPorVenda(Long id){
        return repository.findAllByVendaId(id);
    }

    public List<ItemVenda> buscaTodos() {
        return repository.findAll();
    }

    public ItemVenda buscaPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public ItemVenda alterar(Long id, ItemVenda alterado) {
        Optional<ItemVenda> encontrado = repository.findById(id);
        if (encontrado.isPresent()) {
            ItemVenda venda = encontrado.get();
            venda.setDesconto(alterado.getDesconto());
            venda.setVenda(alterado.getVenda());
            venda.setQuantidade(alterado.getQuantidade());
            return repository.save(venda);
        }
        return null;

    }
}

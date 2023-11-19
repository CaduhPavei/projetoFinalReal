package com.senac.projetoFinal.service;

import com.senac.projetoFinal.models.Produto;
import com.senac.projetoFinal.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    public Produto salvar(Produto entity) {
        if (entity.getPrecoVenda()<entity.getPrecoCompra()){
            throw new RuntimeException("Preço de venda menor que o preço de compra!");
        }
        return repository.save(entity);
    }
    public List<Produto> buscaTodos(){
        return repository.findAll();}
    public Produto buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }
    public Produto alterar(Long id,Produto alterado){
        Optional<Produto> encontrado = repository.findById(id);
        if(encontrado.isPresent()){
            Produto produto = encontrado.get();

            produto.setNome(alterado.getNome());
            produto.setMarca(alterado.getMarca());
            produto.setValidade(alterado.getValidade());
            produto.setPrecoCompra(alterado.getPrecoCompra());
            produto.setPrecoVenda(alterado.getPrecoVenda());
            produto.setQuantidade(alterado.getQuantidade());


            return repository.save(produto);
        }
        return null;
    }
    public void remover(Long id) {repository.deleteById(id);}
}

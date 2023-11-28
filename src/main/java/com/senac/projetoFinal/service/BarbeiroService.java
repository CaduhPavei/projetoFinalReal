package com.senac.projetoFinal.service;

import com.senac.projetoFinal.enterprise.ValidationException;
import com.senac.projetoFinal.models.Barbeiro;
import com.senac.projetoFinal.models.Cliente;
import com.senac.projetoFinal.models.Pessoa;
import com.senac.projetoFinal.repository.BarbeiroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BarbeiroService {

    @Autowired
    private BarbeiroRepository repository;

    public Barbeiro salvar(Barbeiro entity) {

        if(repository.findByCnpj(entity.getCnpj()) != null){
            throw new ValidationException("CNPJ já cadastrado!");
        }

        return repository.save(entity);
    }

    public List<Barbeiro> buscaTodos(){
        return repository.findAll();}

    public Barbeiro buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Barbeiro alterar(Long id,Barbeiro alterado){
        Optional<Barbeiro> encontrado = repository.findById(id);
        if(encontrado.isPresent()){
            Barbeiro barbeiro = encontrado.get();

            barbeiro.setCnpj(alterado.getCnpj());
            barbeiro.setDescricaoBarbeiro(alterado.getDescricaoBarbeiro());
            barbeiro.setComissao(alterado.getComissao());
            barbeiro.setNome(alterado.getNome());
            barbeiro.setContato(alterado.getContato());

            return repository.save(barbeiro);
        }
        return null;
    }
    public void remover(Long id) {repository.deleteById(id);}

}

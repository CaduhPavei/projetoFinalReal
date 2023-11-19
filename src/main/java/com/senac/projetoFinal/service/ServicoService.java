package com.senac.projetoFinal.service;

import com.senac.projetoFinal.models.Servico;
import com.senac.projetoFinal.repository.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class ServicoService {
    @Autowired
    private ServicoRepository repository;

    public Servico salvar(Servico entity) {

        return repository.save(entity);
    }

    public List<Servico> buscaTodos(){
        return repository.findAll();}

    public Servico buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Servico alterar(Long id,Servico alterado){
        Optional<Servico> encontrado = repository.findById(id);
        if(encontrado.isPresent()){
            Servico servico = encontrado.get();

            servico.setDescricaoServico(alterado.getDescricaoServico());
            servico.setTipoServico(alterado.getTipoServico());
            servico.setValor(alterado.getValor());
            servico.setCliente(alterado.getCliente());

            return repository.save(servico);
        }
        return null;
    }
    public void remover(Long id) {repository.deleteById(id);}
}

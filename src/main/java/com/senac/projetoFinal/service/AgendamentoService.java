package com.senac.projetoFinal.service;

import com.senac.projetoFinal.enterprise.ValidationException;
import com.senac.projetoFinal.models.Agendamento;
import com.senac.projetoFinal.repository.AgendamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AgendamentoService {

    @Autowired
    private AgendamentoRepository repository;

    public Agendamento salvar(Agendamento entity) {
        Agendamento existingEntityByData = repository.findByData(entity.getData());
        Agendamento existingEntityByHora = repository.findByHora(entity.getHora());

        if (existingEntityByData != null && existingEntityByHora != null
                && existingEntityByData.getId().equals(existingEntityByHora.getId())) {
            throw new ValidationException("Data e hora já agendados!");
        }

        return repository.save(entity);
    }

    public List<Agendamento> buscaTodos(){
        return repository.findAll();}

    public Agendamento buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Agendamento alterar(Long id, Agendamento alterado){
        Optional<Agendamento> encontrado = repository.findById(id);
        if(encontrado.isPresent()){
            Agendamento agendamento = encontrado.get();

            agendamento.setCliente(alterado.getCliente());
            agendamento.setBarbeiro(alterado.getBarbeiro());
            agendamento.setData(alterado.getData());
            agendamento.setHora(alterado.getHora());
            agendamento.setReservado(alterado.getReservado());

            return repository.save(agendamento);
        }
        return null;
    }
    public void remover(Long id) {repository.deleteById(id);}
}

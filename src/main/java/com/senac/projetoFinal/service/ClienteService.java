package com.senac.projetoFinal.service;

import com.senac.projetoFinal.enterprise.ValidationException;
import com.senac.projetoFinal.models.Cliente;
import com.senac.projetoFinal.models.Pessoa;
import com.senac.projetoFinal.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository repository;

    public Pessoa salvar(Cliente entity) {
        if(entity.getNome().length()<3){
            throw new ValidationException("O nome deve ter mais que 3 caracteres");
        }

        if(repository.findByCpf(entity.getCpf()) != null){
            throw new ValidationException("Já existe um cliente com esse CPF cadastrado!");
        }
        return repository.save(entity);
    }

    public List<Cliente> buscaTodos(){
        return repository.findAll();}

    public Cliente buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Cliente alterar(Long id,Cliente alterado){
        Optional<Cliente> encontrado = repository.findById(id);
        if(encontrado.isPresent()){
            Cliente cliente = encontrado.get();

            cliente.setCpf(alterado.getCpf());
            cliente.setContato(alterado.getContato());
            cliente.setEndereco(alterado.getEndereco());
            cliente.setDataNascimento(alterado.getDataNascimento());
            cliente.setNome(alterado.getNome());

            return repository.save(cliente);
        }
        return null;
    }
    public void remover(Long id) {repository.deleteById(id);}
}

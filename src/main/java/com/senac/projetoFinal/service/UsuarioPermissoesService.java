package com.senac.projetoFinal.service;

import com.senac.projetoFinal.enterprise.ValidationException;
import com.senac.projetoFinal.models.UsuarioPermissoes;
import com.senac.projetoFinal.repository.UsuarioPermissoesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioPermissoesService {

    @Autowired
    private UsuarioPermissoesRepository repository;

    public UsuarioPermissoes salvar(UsuarioPermissoes entity) {

        if(entity.getRotina().isBlank()){
            throw new ValidationException("Rotina não pode ser um campo vazio!");
        }

        return repository.save(entity);
    }

    public List<UsuarioPermissoes> buscaTodos() {
        return repository.findAll();
    }

    public UsuarioPermissoes buscaPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public UsuarioPermissoes alterar(Long id, UsuarioPermissoes alterado) {
        Optional<UsuarioPermissoes> encontrado = repository.findById(id);
        if (encontrado.isPresent()) {
            UsuarioPermissoes usuarioPermissoes = encontrado.get();
            usuarioPermissoes.setRotina(alterado.getRotina());
            usuarioPermissoes.setNivel(alterado.getNivel());
            return repository.save(usuarioPermissoes);
        }
        return null;
    }

    public void remover(Long id) {
        repository.deleteById(id);
    }

}

package com.senac.projetoFinal.service;

import com.senac.projetoFinal.models.UsuarioAcessos;
import com.senac.projetoFinal.repository.UsuarioAcessosRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class UsuarioAcessosService {

    @Autowired
    private UsuarioAcessosRepository repository;

    public UsuarioAcessos salvar(UsuarioAcessos entity) {

        return repository.save(entity);
    }

    public List<UsuarioAcessos> buscaTodos() {
        return repository.findAll();
    }

    public UsuarioAcessos buscaPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public UsuarioAcessos alterar(Long id, UsuarioAcessos alterado) {
        Optional<UsuarioAcessos> encontrado = repository.findById(id);
        if (encontrado.isPresent()) {
            UsuarioAcessos usuarioAcessos = encontrado.get();
            usuarioAcessos.setDataAcesso(alterado.getDataAcesso());
            usuarioAcessos.setTipoChamada(alterado.getTipoChamada());
            return repository.save(usuarioAcessos);
        }
        return null;
    }

    public void remover(Long id) {
        repository.deleteById(id);
    }
}

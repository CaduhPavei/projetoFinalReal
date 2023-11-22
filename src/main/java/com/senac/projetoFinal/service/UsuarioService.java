package com.senac.projetoFinal.service;

import com.senac.projetoFinal.enterprise.ValidationException;
import com.senac.projetoFinal.models.Usuario;
import com.senac.projetoFinal.models.Venda;
import com.senac.projetoFinal.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public Usuario salvar(Usuario entity) {
        if(entity.getUsername().length()<3){
            throw new ValidationException("O nome do usuário deve ter mais que 3 caracteres");
        }

        if(repository.findByUser(entity.getUsername()) != null){
            throw new ValidationException("Nome usuário já cadastrado!");
        }

        if(entity.getPassword().length()>3 && entity.getPassword().length()< 12){
            throw  new ValidationException("Senha tem que ter no mínimo 3 caracteres e menor que 12 caracteres");
        }
        if(entity.getUseremail().isBlank()){
            throw new ValidationException("E-mail não pode ser vazio!");
        }
        return repository.save(entity);
    }

    public List<Usuario> buscaTodos() {
        return repository.findAll();
    }

    public Usuario buscaPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Usuario alterar(Long id, Usuario alterado) {
        Optional<Usuario> encontrado = repository.findById(id);
        if (encontrado.isPresent()) {
            Usuario usuario = encontrado.get();
            usuario.setPassword(alterado.getPassword());
            usuario.setTipo(alterado.getTipo());
            return repository.save(usuario);
        }
        return null;
    }

    public void remover(Long id) {
        repository.deleteById(id);
    }
}

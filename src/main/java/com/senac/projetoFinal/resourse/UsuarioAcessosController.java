package com.senac.projetoFinal.resourse;

import com.senac.projetoFinal.models.UsuarioAcessos;
import com.senac.projetoFinal.service.UsuarioAcessosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/acessos")
public class UsuarioAcessosController extends AbstractController{
    @Autowired
    private UsuarioAcessosService service;

    @PostMapping
    public ResponseEntity create(@RequestBody UsuarioAcessos entity) {
        UsuarioAcessos save = service.salvar(entity);
        return ResponseEntity.created(URI.create("/api/acessos/" + entity.getId())).body(save);
    }

    @GetMapping
    public ResponseEntity findAll() {
        List<UsuarioAcessos> usuarioAcessos = service.buscaTodos();
        return ResponseEntity.ok(usuarioAcessos);
    }

    @GetMapping("{id}")
    public ResponseEntity findById(@PathVariable("id") Long id) {
        UsuarioAcessos usuarioAcessos = service.buscaPorId(id);
        return ResponseEntity.ok(usuarioAcessos);
    }

    @DeleteMapping("{id}")
    public ResponseEntity remove(@PathVariable("id") Long id) {
        service.remover(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity update(@PathVariable("id") Long id, @RequestBody UsuarioAcessos entity) {
        UsuarioAcessos alterado = service.alterar(id, entity);
        return ResponseEntity.ok().body(alterado);
    }
}

package com.senac.projetoFinal.resourse;
import com.senac.projetoFinal.models.UsuarioPermissoes;
import com.senac.projetoFinal.service.UsuarioPermissoesService;
import com.senac.projetoFinal.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/permissoes")
public class UsuarioPermissoesController extends AbstractController{

    @Autowired
    private UsuarioPermissoesService service;

    @PostMapping
    public ResponseEntity create(@RequestBody UsuarioPermissoes entity) {
        UsuarioPermissoes save = service.salvar(entity);
        return ResponseEntity.created(URI.create("/api/permissoes/" + entity.getId())).body(save);
    }

    @GetMapping
    public ResponseEntity findAll() {
        List<UsuarioPermissoes> usuarioPermissoes = service.buscaTodos();
        return ResponseEntity.ok(usuarioPermissoes);
    }

    @GetMapping("{id}")
    public ResponseEntity findById(@PathVariable("id") Long id) {
        UsuarioPermissoes usuarioPermissoes = service.buscaPorId(id);
        return ResponseEntity.ok(usuarioPermissoes);
    }

    @DeleteMapping("{id}")
    public ResponseEntity remove(@PathVariable("id") Long id) {
        service.remover(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity update(@PathVariable("id") Long id, @RequestBody UsuarioPermissoes entity) {
        UsuarioPermissoes alterado = service.alterar(id, entity);
        return ResponseEntity.ok().body(alterado);
    }
}

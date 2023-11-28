package com.senac.projetoFinal.resourse;

import com.senac.projetoFinal.models.Barbeiro;
import com.senac.projetoFinal.models.Pessoa;
import com.senac.projetoFinal.service.BarbeiroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/barbeiros")
public class BarbeiroController extends AbstractController{

    @Autowired
    private BarbeiroService service;

    @PostMapping
    public ResponseEntity create(@RequestBody Barbeiro entity) {
        Pessoa save = service.salvar(entity);
        return ResponseEntity.created(URI.create("/api/barbeiros/" + entity.getId())).body(save);
    }

    @GetMapping
    public ResponseEntity findAll() {
        List<Barbeiro> barbeiros = service.buscaTodos();
        return ResponseEntity.ok(barbeiros);
    }

    @GetMapping("{id}")
    public ResponseEntity findById(@PathVariable("id") Long id) {
        Barbeiro barbeiro = service.buscarPorId(id);
        return ResponseEntity.ok(barbeiro);
    }

    @DeleteMapping("{id}")
    public ResponseEntity remove(@PathVariable("id") Long id) {
        service.remover(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity update(@PathVariable("id") Long id, @RequestBody Barbeiro entity) {
        Barbeiro alterado = service.alterar(id, entity);
        return ResponseEntity.ok().body(alterado);
    }
}

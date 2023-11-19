package com.senac.projetoFinal.resourse;

import com.senac.projetoFinal.models.Cliente;
import com.senac.projetoFinal.models.Pessoa;
import com.senac.projetoFinal.models.Servico;
import com.senac.projetoFinal.service.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping
public class ServicoController extends AbstractController{

    @Autowired
    private ServicoService service;

    @PostMapping
    public ResponseEntity create(@RequestBody Servico entity) {
        Servico save = service.salvar(entity);
        return ResponseEntity.created(URI.create("/api/servicos/" + entity.getId())).body(save);
    }

    @GetMapping
    public ResponseEntity findAll() {
        List<Servico> servicos = service.buscaTodos();
        return ResponseEntity.ok(servicos);
    }

    @GetMapping("{id}")
    public ResponseEntity findById(@PathVariable("id") Long id) {
        Servico servicos = service.buscarPorId(id);
        return ResponseEntity.ok(servicos);
    }

    @DeleteMapping("{id}")
    public ResponseEntity remove(@PathVariable("id") Long id) {
        service.remover(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity update(@PathVariable("id") Long id, @RequestBody Servico entity) {
        Servico alterado = service.alterar(id, entity);
        return ResponseEntity.ok().body(alterado);
    }
}

package com.senac.projetoFinal.resourse;

import com.senac.projetoFinal.models.Agendamento;
import com.senac.projetoFinal.models.Cliente;

import com.senac.projetoFinal.service.AgendamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/agendamentos")
public class AgendamentoController extends AbstractController{
    @Autowired
    private AgendamentoService service;

    @PostMapping
    public ResponseEntity create(@RequestBody Agendamento entity) {
        Agendamento save = service.salvar(entity);
        return ResponseEntity.created(URI.create("/api/agendamentos/" + entity.getId())).body(save);
    }

    @GetMapping
    public ResponseEntity findAll() {
        List<Agendamento> agendamentos = service.buscaTodos();
        return ResponseEntity.ok(agendamentos);
    }

    @GetMapping("{id}")
    public ResponseEntity findById(@PathVariable("id") Long id) {
        Agendamento agendamento = service.buscarPorId(id);
        return ResponseEntity.ok(agendamento);
    }

    @DeleteMapping("{id}")
    public ResponseEntity remove(@PathVariable("id") Long id) {
        service.remover(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity update(@PathVariable("id") Long id, @RequestBody Agendamento entity) {
        Agendamento alterado = service.alterar(id, entity);
        return ResponseEntity.ok().body(alterado);
    }
}

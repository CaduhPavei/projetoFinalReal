package com.senac.projetoFinal.resourse;
import com.senac.projetoFinal.models.Cliente;
import com.senac.projetoFinal.models.Pessoa;
import com.senac.projetoFinal.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController extends AbstractController{

    @Autowired
    private ClienteService service;

    @PostMapping
    public ResponseEntity create(@RequestBody Cliente entity) {
        Pessoa save = service.salvar(entity);
        return ResponseEntity.created(URI.create("/api/clientes/" + entity.getId())).body(save);
    }

    @GetMapping
    public ResponseEntity findAll() {
        List<Cliente> clientes = service.buscaTodos();
        return ResponseEntity.ok(clientes);
    }

    @GetMapping("{id}")
    public ResponseEntity findById(@PathVariable("id") Long id) {
        Cliente cliente = service.buscarPorId(id);
        return ResponseEntity.ok(cliente);
    }

    @DeleteMapping("{id}")
    public ResponseEntity remove(@PathVariable("id") Long id) {
        service.remover(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity update(@PathVariable("id") Long id, @RequestBody Cliente entity) {
        Cliente alterado = service.alterar(id, entity);
        return ResponseEntity.ok().body(alterado);
    }
}

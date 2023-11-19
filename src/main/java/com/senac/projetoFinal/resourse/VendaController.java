package com.senac.projetoFinal.resourse;

import com.senac.projetoFinal.models.ItemVenda;
import com.senac.projetoFinal.models.Venda;
import com.senac.projetoFinal.service.ItemVendaService;
import com.senac.projetoFinal.service.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/vendas")
public class VendaController extends AbstractController {

    @Autowired
    private VendaService service;

    @Autowired
    private ItemVendaService itemVendaService;

    @PostMapping
    public ResponseEntity create(@RequestBody Venda entity) {
        Venda save = service.salvar(entity);
        return ResponseEntity.created(URI.create("/api/vendas/itens" + entity.getId())).body(save);
    }

    @GetMapping
    public ResponseEntity findAll() {
        List<Venda> vendas = service.buscaTodos();
        return ResponseEntity.ok(vendas);
    }

    @GetMapping("{id}")
    public ResponseEntity findById(@PathVariable("id") Long id) {
        Venda venda = service.buscaPorId(id);
        return ResponseEntity.ok(venda);
    }

    @DeleteMapping("{id}")
    public ResponseEntity remove(@PathVariable("id") Long id) {
        service.remover(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity update(@PathVariable("id") Long id, @RequestBody Venda entity) {
        Venda alterado = service.alterar(id, entity);
        return ResponseEntity.ok().body(alterado);
    }
    @PostMapping("{id}/item")
    public ResponseEntity createItem(@RequestBody ItemVenda entity) {
        ItemVenda save = itemVendaService.salvar(entity);
        return ResponseEntity.created(URI.create("/api/vendas/itens" + entity.getId())).body(save);
    }
    @GetMapping("{id}/item")
    public ResponseEntity findByVenda(@PathVariable("id") Long id) {
        List<ItemVenda> itemVendas = itemVendaService.buscaTodosPorVenda(id);
        return ResponseEntity.ok(itemVendas);
    }
}

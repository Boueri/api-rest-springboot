package com.exemplo.projeto.controller;

import com.exemplo.projeto.model.Pedido;
import com.exemplo.projeto.service.PedidoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    private final PedidoService service;

    public PedidoController(PedidoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Pedido>> listar() {
        List<Pedido> lista = service.listarTodos();
        return ResponseEntity.ok(lista); // Retorna HTTP 200 OK com a lista
    }

    @PostMapping
    public ResponseEntity<Pedido> criar(@RequestBody Pedido pedido) {
        Pedido novoPedido = service.criarPedido(pedido);
        
        // Constrói a URL do novo recurso criado (ex: http://localhost:8080/api/pedidos/1)
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(novoPedido.getId())
                .toUri();
                
        return ResponseEntity.created(uri).body(novoPedido); // Retorna HTTP 201 Created
    }
}
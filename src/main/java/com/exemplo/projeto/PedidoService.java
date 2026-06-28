package com.exemplo.projeto.service;

import com.exemplo.projeto.model.Cliente;
import com.exemplo.projeto.model.Pedido;
import com.exemplo.projeto.model.Produto;
import com.exemplo.projeto.repository.ClienteRepository;
import com.exemplo.projeto.repository.PedidoRepository;
import com.exemplo.projeto.repository.ProdutoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;
    private final ProdutoRepository produtoRepository;
    private final ClienteRepository clienteRepository;

    // Injeção via Construtor (Boa prática que substitui o @Autowired)
    public PedidoService(PedidoRepository pedidoRepository, ProdutoRepository produtoRepository, ClienteRepository clienteRepository) {
        this.pedidoRepository = pedidoRepository;
        this.produtoRepository = produtoRepository;
        this.clienteRepository = clienteRepository;
    }

    public List<Pedido> listarTodos() {
        return pedidoRepository.findAll();
    }

    @Transactional // Garante consistência de banco (ACID)
    public Pedido criarPedido(Pedido pedido) {
        // 1. Valida se o cliente de fato existe no banco
        Cliente clienteDoBanco = clienteRepository.findById(pedido.getCliente().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado com o ID: " + pedido.getCliente().getId()));
        pedido.setCliente(clienteDoBanco);

        // 2. Carrega os produtos e calcula o valor total
        double valorTotal = 0.0;
        List<Produto> produtosCarregados = new ArrayList<>();

        for (Produto p : pedido.getProdutos()) {
            Produto produtoDoBanco = produtoRepository.findById(p.getId())
                    .orElseThrow(() -> new ResourceNotFoundException("Produto não encontrado com o ID: " + p.getId()));
            
            valorTotal += produtoDoBanco.getPreco();
            produtosCarregados.add(produtoDoBanco);
        }

        pedido.setProdutos(produtosCarregados);
        pedido.setTotal(valorTotal);

        return pedidoRepository.save(pedido);
    }
}
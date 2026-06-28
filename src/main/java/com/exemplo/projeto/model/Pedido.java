package com.exemplo.projeto.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity // Diz ao Spring que esta classe representa uma tabela no banco
@Table(name = "tb_pedidos") // Define o nome da tabela no banco de dados
public class Pedido {

    @Id // Define que este campo é a Chave Primária (Primary Key)
    @GeneratedValue(strategy = GenerationType.IDENTITY) // O banco vai gerar o ID automaticamente (1, 2, 3...)
    private Long id;

    @Column(name = "cliente_id", nullable = false) // Configura a coluna no banco (não pode ser nula)
    private Long clienteId;

    @Column(nullable = false, length = 255) // Define tamanho máximo do texto
    private String descricao; // Corrigido de 'description' para 'descricao'

    @Column(name = "valor_total", nullable = false)
    private Double valorTotal;

    @Column(name = "data_criacao", nullable = false, updatable = false)
    private LocalDateTime dataCriacao;

    // O JPA OBRIGA a ter um construtor padrão vazio.
    public Pedido() {
    }

    // Getters e Setters corrigidos e alinhados
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getClienteId() { return clienteId; }
    public void setClienteId(Long clienteId) { this.clienteId = clienteId; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public Double getValorTotal() { return valorTotal; }
    public void setValorTotal(Double valorTotal) { this.valorTotal = valorTotal; }

    public LocalDateTime getDataCriacao() { return dataCriacao; }
    public void setDataCriacao(LocalDateTime dataCriacao) { this.dataCriacao = dataCriacao; }
}
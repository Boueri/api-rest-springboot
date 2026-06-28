package com.exemplo.projeto.controller.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import io.swagger.v3.oas.annotations.media.Schema;

public class PedidoRequestDTO {

    @Schema(description = "Identificador do cliente que fez o pedido", example = "452")
    @NotNull(message = "O ID do cliente é obrigatório")
    private Long clienteId;

    @Schema(description = "Descrição ou observação do pedido", example = "Entregar no bloco B")
    @NotBlank(message = "A descrição não pode estar em branco")
    private String descricao;

    @Schema(description = "Valor total do pedido", example = "250.75")
    @NotNull(message = "O valor total é obrigatório")
    @Positive(message = "O valor deve ser maior que zero")
    private Double valorTotal;

    // Getters e Setters ou use as anotações do Lombok (@Data)
}
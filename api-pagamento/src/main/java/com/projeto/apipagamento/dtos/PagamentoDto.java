package com.projeto.apipagamento.dtos;

import jakarta.validation.constraints.NotBlank;

public class PagamentoDto {
    @NotBlank(message = "O campo 'descricao' é obrigatório.")
    private String descricao;

    // Getters e setters

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}

package com.projeto.apicarrinhoproduto.dtos;

import com.projeto.apipagamento.entites.Status;

public class CarrinhoDto {
    private Long id;
    private Status status;
    private Long pagamentoId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Long getPagamentoId() {
        return pagamentoId;
    }

    public void setPagamentoId(Long pagamentoId) {
        this.pagamentoId = pagamentoId;
    }
}

package com.projeto.apipagamento.entites;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_pagamentos")
public class Pagamento implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal valor;

    private String nome;

    @Column(name = "numero_cartao")
    private String numeroCartao;

    @Column(name = "expiracao_cartao")
    private LocalDate expiracaoCartao;

    private String codigo;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = "carrinho_id")
    private Long carrinhoId;

    public Pagamento() {

    }

    // Getters e setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public LocalDate getExpiracaoCartao() {
        return expiracaoCartao;
    }

    public void setExpiracaoCartao(LocalDate expiracaoCartao) {
        this.expiracaoCartao = expiracaoCartao;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(String string) {
        this.status = string;
    }

    public Long getCarrinhoId() {
        return carrinhoId;
    }

    public void setCarrinhoId(Long carrinhoId) {
        this.carrinhoId = carrinhoId;
    }
}

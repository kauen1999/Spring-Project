package com.projeto.apipagamento.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import com.projeto.apipagamento.dtos.PagamentoDto;
import com.projeto.apipagamento.services.PagamentoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/pagamentos", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class PagamentoController {

    private final PagamentoService pagamentoService;

    @Autowired
    public PagamentoController(PagamentoService pagamentoService) {
        this.pagamentoService = pagamentoService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<PagamentoDto> salvar(@RequestBody @Valid PagamentoDto pagamentoDto, UriComponentsBuilder uriBuilder) {
        PagamentoDto pagamentoCriado = pagamentoService.salvar(pagamentoDto);
        pagamentoService.atualizarStatusCarrinho(pagamentoCriado.getCarrinhoId(), pagamentoCriado.getStatus());

        return ResponseEntity.created(uriBuilder.path("/pagamentos/{id}")
                .buildAndExpand(pagamentoCriado.getId()).toUri())
                .body(pagamentoCriado);
    }
}

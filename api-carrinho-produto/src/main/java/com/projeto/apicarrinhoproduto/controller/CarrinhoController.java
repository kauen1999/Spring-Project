package com.projeto.apicarrinhoproduto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.apicarrinhoproduto.dtos.CarrinhoDto;
import com.projeto.apicarrinhoproduto.services.CarrinhoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/carrinhos", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
public class CarrinhoController {

    private final CarrinhoService carrinhoService;

    @Autowired
    public CarrinhoController(CarrinhoService carrinhoService) {
        this.carrinhoService = carrinhoService;
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<CarrinhoDto> criarCarrinho(@RequestBody @Valid CarrinhoDto carrinhoDto) {
        CarrinhoDto carrinhoCriado = carrinhoService.criarCarrinho(carrinhoDto);
        return ResponseEntity.ok(carrinhoCriado);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarrinhoDto> buscarCarrinhoPorId(@PathVariable Long id) {
        CarrinhoDto carrinho = carrinhoService.buscarCarrinhoPorId(id);

        if (carrinho != null) {
            return ResponseEntity.ok(carrinho);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}

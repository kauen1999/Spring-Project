package com.projeto.apicarrinhoproduto.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.apicarrinhoproduto.dtos.ProdutoDto;
import com.projeto.apicarrinhoproduto.services.ProdutoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/produtos", produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public ResponseEntity<List<ProdutoDto>> listarProdutos() {
        List<ProdutoDto> produtos = produtoService.listarProdutos();
        return ResponseEntity.ok(produtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<ProdutoDto>> buscarProdutoPorId(@PathVariable Long id) {
        Optional<ProdutoDto> produto = produtoService.buscarProdutoPorId(id);
        return ResponseEntity.ok(produto);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<ProdutoDto> criarProduto(@RequestBody @Valid ProdutoDto produtoDto) {
        ProdutoDto produtoCriado = produtoService.criarProduto(produtoDto);
        return ResponseEntity.ok(produtoCriado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Optional<ProdutoDto>> atualizarProduto(@PathVariable Long id, @RequestBody @Valid ProdutoDto produtoDto) {
        Optional<ProdutoDto> produtoAtualizado = produtoService.atualizarProduto(id, produtoDto);
        return ResponseEntity.ok(produtoAtualizado);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deletarProduto(@PathVariable Long id) {
        produtoService.deletarProduto(id);
    }
}

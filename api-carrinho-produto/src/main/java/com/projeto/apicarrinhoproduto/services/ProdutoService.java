package com.projeto.apicarrinhoproduto.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.apicarrinhoproduto.dtos.ProdutoDto;
import com.projeto.apicarrinhoproduto.entites.Produto;
import com.projeto.apicarrinhoproduto.repository.ProdutoRepository;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<ProdutoDto> listarProdutos() {
        List<Produto> produtos = produtoRepository.findAll();
        return produtos.stream()
                .map(produto -> modelMapper.map(produto, ProdutoDto.class))
                .collect(Collectors.toList());
    }

    public Optional<ProdutoDto> buscarProdutoPorId(Long id) {
        Optional<Produto> produtoOptional = produtoRepository.findById(id);
        return produtoOptional.map(produto -> modelMapper.map(produto, ProdutoDto.class));
    }

    public ProdutoDto criarProduto(ProdutoDto produtoDto) {
        Produto produto = modelMapper.map(produtoDto, Produto.class);
        Produto produtoCriado = produtoRepository.save(produto);
        return modelMapper.map(produtoCriado, ProdutoDto.class);
    }

    public Optional<ProdutoDto> atualizarProduto(Long id, ProdutoDto produtoDto) {
        Optional<Produto> produtoOptional = produtoRepository.findById(id);
        if (produtoOptional.isPresent()) {
            Produto produto = produtoOptional.get();
            produto.setNome(produtoDto.getNome());
            produto.setQuantidade(produtoDto.getQuantidade());
            produto.setDescricao(produtoDto.getDescricao());
            Produto produtoAtualizado = produtoRepository.save(produto);
            return Optional.of(modelMapper.map(produtoAtualizado, ProdutoDto.class));
        } else {
            return Optional.empty();
        }
    }

    public void deletarProduto(Long id) {
        produtoRepository.deleteById(id);
    }
}

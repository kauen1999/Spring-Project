package com.projeto.apicarrinhoproduto.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.apicarrinhoproduto.dtos.CarrinhoDto;
import com.projeto.apicarrinhoproduto.entites.Carrinho;
import com.projeto.apicarrinhoproduto.repository.CarrinhoRepository;

@Service
public class CarrinhoService {

    @Autowired
    private CarrinhoRepository carrinhoRepository;

    @Autowired
    private ModelMapper modelMapper;

    public CarrinhoDto criarCarrinho(Carrinho carrinhoDto) {
        Carrinho carrinho = modelMapper.map(carrinhoDto, Carrinho.class);
        Carrinho carrinhoSalvo = carrinhoRepository.save(carrinho);
        return modelMapper.map(carrinhoSalvo, CarrinhoDto.class);
    }

    public CarrinhoDto buscarCarrinhoPorId(Long id) {
        java.util.Optional<Carrinho> carrinhoOptional = carrinhoRepository.findById(id);
        return carrinhoOptional.map(carrinho -> modelMapper.map(carrinho, CarrinhoDto.class)).orElse(null);
    }

	public Carrinho obterCarrinhoPorId(Long carrinhoId) {
		// TODO Auto-generated method stub
		return null;
	}

    // Outros métodos do serviço...
}

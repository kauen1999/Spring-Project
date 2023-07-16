package com.projeto.apipagamento.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.apicarrinhoproduto.entites.Carrinho;
import com.projeto.apicarrinhoproduto.services.CarrinhoService;
import com.projeto.apipagamento.dtos.PagamentoDto;
import com.projeto.apipagamento.entites.Pagamento;
import com.projeto.apipagamento.entites.Status;
import com.projeto.apipagamento.repository.PagamentoRepository;

@Service
public class PagamentoService {

    private final PagamentoRepository pagamentoRepository;
    private final CarrinhoService carrinhoService;

    @Autowired
    public PagamentoService(PagamentoRepository pagamentoRepository, CarrinhoService carrinhoService) {
        this.pagamentoRepository = pagamentoRepository;
        this.carrinhoService = carrinhoService;
    }

    public PagamentoDto salvar(PagamentoDto pagamentoDto) {
        Pagamento pagamento = new Pagamento();
        pagamento.setCarrinhoId(pagamentoDto.getCarrinhoId());
        pagamento.setStatus("Pendente");
        
        Pagamento pagamentoSalvo = pagamentoRepository.save(pagamento);
        
        PagamentoDto pagamentoCriado = new PagamentoDto();
        pagamentoCriado.setId(pagamentoSalvo.getId());
        pagamentoCriado.setCarrinhoId(pagamentoSalvo.getCarrinhoId());
        pagamentoCriado.setStatus(pagamentoSalvo.getStatus());
        
        return pagamentoCriado;
    }

    public void atualizarStatusCarrinho(Long carrinhoId, Status status) {
        Carrinho carrinho = carrinhoService.obterCarrinhoPorId(carrinhoId);
        carrinho.setStatus(status);
        carrinhoService.criarCarrinho(carrinho);
    }
}

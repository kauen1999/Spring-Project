package com.projeto.apipagamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projeto.apipagamento.entites.Pagamento;

@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {

}

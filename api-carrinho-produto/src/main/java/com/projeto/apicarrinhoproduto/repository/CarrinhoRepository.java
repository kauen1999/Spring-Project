package com.projeto.apicarrinhoproduto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projeto.apicarrinhoproduto.entites.Carrinho;


@Repository
public interface CarrinhoRepository extends JpaRepository<Carrinho, Long> {
}

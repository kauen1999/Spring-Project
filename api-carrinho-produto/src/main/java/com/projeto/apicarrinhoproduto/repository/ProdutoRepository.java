package com.projeto.apicarrinhoproduto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projeto.apicarrinhoproduto.entites.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}

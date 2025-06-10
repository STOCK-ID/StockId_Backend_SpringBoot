package com.stockid.stockid.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stockid.stockid.model.Estoque;
import com.stockid.stockid.model.Produto;

public interface EstoqueRepository extends JpaRepository<Estoque, Integer>{

    List<Estoque> findByProduto(Produto produto);
}

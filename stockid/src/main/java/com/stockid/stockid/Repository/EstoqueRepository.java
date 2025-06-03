package com.stockid.stockid.Repository;

import java.util.Optional;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stockid.stockid.model.Estoque;

public interface EstoqueRepository extends JpaRepository<Estoque, Integer>{

    public Optional<Estoque> findByLote(String lote);

    public Optional<List<Estoque>> findByProduto(Integer id_produto);
}

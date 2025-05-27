package com.stockid.stockid.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stockid.stockid.enums.EnumCategoria;
import com.stockid.stockid.model.Marca;
import com.stockid.stockid.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer>{

    public Produto findByGtin(String gtin);

    public List<Produto> findByCategoria(EnumCategoria categoria);

    public List<Produto> findByMarca(Marca marca);

}

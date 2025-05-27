package com.stockid.stockid.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stockid.stockid.Repository.ProdutoRepository;
import com.stockid.stockid.model.Produto;
@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepostory;

    public List<Produto> getAllProducts() {
        return produtoRepostory.findAll();
    }
}

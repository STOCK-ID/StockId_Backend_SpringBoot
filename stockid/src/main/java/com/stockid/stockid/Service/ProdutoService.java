package com.stockid.stockid.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stockid.stockid.Repository.ProdutoRepository;
import com.stockid.stockid.model.Produto;
@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> getAllProducts() {
        return produtoRepository.findAll();
    }

    public Produto getProdutoById(Integer id) {
        return produtoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto nã encontrado com o id: " + id));
    }
}

package com.stockid.stockid.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stockid.stockid.Repository.ProdutoRepository;
import com.stockid.stockid.model.Marca;
import com.stockid.stockid.model.Produto;
import com.stockid.stockid.model.WriteDTOs.ProdutoWriteDTO;

import jakarta.transaction.Transactional;
@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private MarcaService marcaService;

    public List<Produto> getAllProducts() {
        return produtoRepository.findAll();
    }

    public Produto getProdutoById(Integer id) {
        return produtoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado com o id: " + id));
    }

    public Produto getProdutoByGtin(String gtin) {
        
        if(!gtin.matches("\\d{8,14}")) {
            throw new IllegalArgumentException("GTIN deve conter entre 8 e 14 dígitos.");
        }

        return produtoRepository.findByGtin(gtin).
                orElseThrow(() -> new RuntimeException("Produto não encontrado com o GTIN: " + gtin));
    }

    @Transactional
    public Produto createProduto(ProdutoWriteDTO produtoWriteDTO) {
        Marca marca = marcaService.getMarcaById(produtoWriteDTO.getMarcaId());

        Produto produto = new Produto(marca,
                produtoWriteDTO.getCategoria(),
                produtoWriteDTO.getGtin(),
                produtoWriteDTO.getNome(),
                produtoWriteDTO.getUnidadeDesc());

        return produtoRepository.save(produto);

    }
}

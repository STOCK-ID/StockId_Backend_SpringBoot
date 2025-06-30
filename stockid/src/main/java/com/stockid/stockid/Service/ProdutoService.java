package com.stockid.stockid.Service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stockid.stockid.Repository.ProdutoRepository;
import com.stockid.stockid.model.Marca;
import com.stockid.stockid.model.Produto;
import com.stockid.stockid.model.DTOs.ProdutoDTO;
import com.stockid.stockid.model.WriteDTOs.ProdutoWriteDTO;

import jakarta.transaction.Transactional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private MarcaService marcaService;

    public List<ProdutoDTO> getAllProducts() {
        List<Produto> produtos = produtoRepository.findAll();

        return produtos.stream().map(Produto::toDTO).toList();
    }

    public Produto getProdutoByIdOrThrow(Integer id) {
        return produtoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado com o id: " + id));
    }

    public Produto getProdutoByGtinOrThrow(String gtin) {
        
        if(!gtin.matches("\\d{8,14}")) {
            throw new IllegalArgumentException("GTIN deve conter entre 8 e 14 dígitos.");
        }

        return produtoRepository.findByGtin(gtin).
                orElseThrow(() -> new RuntimeException("Produto não encontrado com o GTIN: " + gtin));
    }

    @Transactional
    public Produto createProduto(ProdutoWriteDTO produtoWriteDTO) {
        Marca marca = marcaService.getMarcaByIdOrThrow(produtoWriteDTO.getMarcaId());

        Produto produto = new Produto(marca,
                produtoWriteDTO.getCategoria(),
                produtoWriteDTO.getGtin(),
                produtoWriteDTO.getNome(),
                produtoWriteDTO.getUnidadeDesc());

        return produtoRepository.save(produto);

    }

    @Transactional
    public Produto updateProduto(Integer id, ProdutoWriteDTO produtoWriteDTO) {
        
        Produto lastProduto = getProdutoByIdOrThrow(id);

        Marca marca = marcaService.getMarcaByIdOrThrow(produtoWriteDTO.getMarcaId());

        lastProduto.setNome(produtoWriteDTO.getNome());
        lastProduto.setMarca(marca);
        lastProduto.setCategoria(produtoWriteDTO.getCategoria());
        lastProduto.setUnidadeDesc(produtoWriteDTO.getUnidadeDesc());

        lastProduto.setLastUpdate(LocalDateTime.now());

        return produtoRepository.save(lastProduto);
    }

    @Transactional
    public Produto deleteProduto(Integer id) {
        Produto produto = getProdutoByIdOrThrow(id);

        produto.setActive(false);
        produto.setLastUpdate(LocalDateTime.now());

        return produtoRepository.save(produto);
    }

    @Transactional
    public Produto reactivateProduto(Integer id) {
        Produto produto = getProdutoByIdOrThrow(id);

        if(produto.isActive()) {
            throw new RuntimeException("Produto já está ativo");
        }

        produto.setActive(true);
        produto.setLastUpdate(LocalDateTime.now());

        return produtoRepository.save(produto);
    }
}

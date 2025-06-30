package com.stockid.stockid.Service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stockid.stockid.Repository.EstoqueRepository;
import com.stockid.stockid.model.Estoque;
import com.stockid.stockid.model.Produto;
import com.stockid.stockid.model.DTOs.EstoqueDTO;
import com.stockid.stockid.model.WriteDTOs.EstoqueWriteDTO;

import jakarta.transaction.Transactional;

@Service
public class EstoqueService {

    @Autowired
    EstoqueRepository estoqueRepository;

    @Autowired
    ProdutoService produtoService;

    public Estoque createLote(EstoqueWriteDTO estoqueWriteDTO) {
        Produto produto = produtoService.getProdutoByIdOrThrow(estoqueWriteDTO.getProdutoId());
        
        Estoque newEstoque = new Estoque(estoqueWriteDTO);
        newEstoque.setProduto(produto);

        return estoqueRepository.save(newEstoque);
    }

    public List<EstoqueDTO> findAllEstoque() {
        List<Estoque> estoques = estoqueRepository.findAll(); 
        
        return estoques.stream().map(Estoque::toDTO).toList();
    }

    public Estoque findByIdOrThrow(Integer id) {
        return estoqueRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Estoque não encontrado " + id));
    }

    @Transactional
    public Estoque update(EstoqueWriteDTO estoqueW, Integer id_estoque) {
        Estoque estoque = findByIdOrThrow(id_estoque);

        Estoque newEstoque = new Estoque(estoqueW);
        
        if(estoque.equals(newEstoque)) {
            throw new IllegalArgumentException("Nenhuma dado divergente para atualização");
        }

        estoque.initBy(estoqueW);
        estoque.setLastUpdate(LocalDateTime.now());

        return estoque;
    }
}

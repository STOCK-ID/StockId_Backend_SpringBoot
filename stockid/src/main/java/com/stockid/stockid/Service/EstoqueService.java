package com.stockid.stockid.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stockid.stockid.Repository.EstoqueRepository;
import com.stockid.stockid.model.Estoque;
import com.stockid.stockid.model.Produto;
import com.stockid.stockid.model.WriteDTOs.EstoqueWriteDTO;

@Service
public class EstoqueService {

    @Autowired
    EstoqueRepository estoqueRepository;

    @Autowired
    ProdutoService produtoService;

    public Estoque createLote(EstoqueWriteDTO estoqueWriteDTO) {
        Produto produto = produtoService.getProdutoById(estoqueWriteDTO.getProdutoId());
        
        Estoque newEstoque = new Estoque(
            produto,
            estoqueWriteDTO.getLote(),
            estoqueWriteDTO.getQuantidadeAtual(),
            estoqueWriteDTO.getQuantidadeMinima(),
            estoqueWriteDTO.getUnidadeMEdida(),
            estoqueWriteDTO.getValidade(),
            estoqueWriteDTO.getEntrada(),
            estoqueWriteDTO.getPrecoCompra(),
            estoqueWriteDTO.getPrecoVenda(),
            estoqueWriteDTO.getStatusLote()
        );

        Estoque estoque = estoqueRepository.save(newEstoque);

        return estoque;
    }

    public List<Estoque> findAllEstoque() {
        return estoqueRepository.findAll();
    }

    public Estoque findByIdOrThrow(Integer id) {
        return estoqueRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Estoque não encontrado " + id));
    }
}

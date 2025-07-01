package com.stockid.stockid.Configs.DataBase;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stockid.stockid.Repository.ProdutoRepository;
import com.stockid.stockid.Service.ProdutoService;
import com.stockid.stockid.enums.EnumCategoria;
import com.stockid.stockid.model.Produto;
import com.stockid.stockid.model.WriteDTOs.ProdutoWriteDTO;

@Service
public class InitProduto {

    @Autowired
    ProdutoRepository produtoRepository;

    @Autowired
    ProdutoService produtoService;

    private List<ProdutoWriteDTO> produtos = new ArrayList<>();

    private void setProdutos() {
        if (produtoRepository.count() == 0) {
            produtos.add(new ProdutoWriteDTO(1, "Achocolatado Nescau", "7891000059128", "lata 400g",
                    EnumCategoria.ALIMENTO)); // Nestlé

            produtos.add(new ProdutoWriteDTO(2, "Smartphone Galaxy A14", "8806094787756", "unidade",
                    EnumCategoria.ELETRONICO)); // Samsung

            produtos.add(
                    new ProdutoWriteDTO(3, "Tênis Nike Revolution 6", "195243242185", "par", EnumCategoria.VESTUARIO)); // Nike

            produtos.add(new ProdutoWriteDTO(4, "Caneta esferográfica azul", "7891025114301", "pacote c/10",
                    EnumCategoria.PAPELARIA)); // BIC

            produtos.add(new ProdutoWriteDTO(5, "Faca Tramontina para churrasco", "7891112002187", "unidade",
                    EnumCategoria.UTENSILIO_DOMESTICO)); // Tramontina
        }
    }

    public void initProduto() {
        System.out.println("\n\nIniciando INIT PRODUTOS");

        if (produtoRepository.count() == 0) {
            setProdutos();

            System.out.println("===== CRIANDO PRODUTOS =====");

            for (ProdutoWriteDTO produto : produtos) {
                System.out.println("=== PRODUTO: " + produto.getNome());

                try {   
                    Produto p = produtoService.createProduto(produto);

                    if (p != null) {
                        System.out.println("Produto criado com sucesso!");
                    }
                } catch (Exception e) {
                    System.out.println("Erro ao salvar marca: " + produto.getNome());
                    System.out.println("ERRO LOG: " + e.getMessage());
                }
            }
            System.out.println("===== Cadastro de PRODUTO FINALIZADO");
        }
        else {
            System.out.println("===== Já esxiste PRODUTOS REGISTRADOS!");
        }
    }
}

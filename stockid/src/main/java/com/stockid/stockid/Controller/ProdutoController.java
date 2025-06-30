package com.stockid.stockid.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spec.speedspring.core.controller.GenericRestController;
import com.spec.speedspring.core.responses.GenericResponse;
import com.stockid.stockid.Service.ProdutoService;
import com.stockid.stockid.model.Produto;
import com.stockid.stockid.model.DTOs.ProdutoDTO;
import com.stockid.stockid.model.WriteDTOs.ProdutoWriteDTO;


@RestController
@RequestMapping("api/produtos")
public class ProdutoController extends GenericRestController{

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public ResponseEntity<GenericResponse> getAllProduct() {
        try {
            List<ProdutoDTO> produtos = produtoService.getAllProducts();

            return getResponseOK("Produtos encontrados!", produtos);
        } catch (Exception e) {
            return getResponseException(e);
        }
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<GenericResponse> getProdutoById(@PathVariable Integer id) {
        try {
            Produto produto = produtoService.getProdutoByIdOrThrow(id);

            return getResponseOK("Produto encontrado com sucesso!", produto.toDTO());
        } catch (Exception e) {
            return getResponseException(e);
        }
    }

    @GetMapping("/gtin/{gtin}")
    public ResponseEntity<GenericResponse> getProdutoByGtin(@PathVariable String gtin) {
        try {
            Produto produto = produtoService.getProdutoByGtinOrThrow(gtin);

            return getResponseOK("Produto encontrado com sucesso!", produto.toDTO());
        } catch (Exception e) {
            return getResponseException(e);
        }
    }

    @PostMapping
    public ResponseEntity<GenericResponse> createrProduto(@RequestBody ProdutoWriteDTO produtoWriteDTO) {
        try {
            Produto produto = produtoService.createProduto(produtoWriteDTO);
            
            return getResponseOK("Produto cadastrado com sucesso!", produto.toDTO());
        } catch (Exception e) {
            return getResponseException(e);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<GenericResponse> updateProduto(@PathVariable Integer id, @RequestBody ProdutoWriteDTO produtoWriteDTO) {
        try {
            Produto updateProduto = produtoService.updateProduto(id, produtoWriteDTO);
            
            return getResponseOK("Produto atualizado com sucesso!", updateProduto.toDTO());
        } catch (Exception e) {
            return getResponseException(e);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<GenericResponse> deleteProduto(@PathVariable Integer id) {
        try {
            Produto produto = produtoService.deleteProduto(id);

            return getResponseOK("Produto deletado com sucesso!", produto.toDTO());
        } catch (Exception e) {
            return getResponseException(e);
        }

    }

    @PatchMapping("/{id}")
    public ResponseEntity<GenericResponse> reactivateProduto(@PathVariable Integer id) {
        try {
            Produto produto = produtoService.reactivateProduto(id);

            return getResponseOK("Produto reativado com sucesso", produto.toDTO());
        } catch (Exception e) {
            return getResponseException(e);
        }
    }
 }

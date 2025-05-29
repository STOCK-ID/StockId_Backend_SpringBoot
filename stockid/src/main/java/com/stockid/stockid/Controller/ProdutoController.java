package com.stockid.stockid.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stockid.stockid.Service.ProdutoService;
import com.stockid.stockid.model.Produto;
import com.stockid.stockid.model.WriteDTOs.ProdutoWriteDTO;


@RestController
@RequestMapping("api/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public ResponseEntity<List<Produto>> getAllProduct() {
        return ResponseEntity.ok(produtoService.getAllProducts());
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Produto> getProdutoById(@PathVariable Integer id) {
        return ResponseEntity.ok(produtoService.getProdutoById(id));
    }

    @GetMapping("/gtin/{gtin}")
    public ResponseEntity<Produto> getProdutoByGtin(@PathVariable String gtin) {
        return ResponseEntity.ok(produtoService.getProdutoByGtin(gtin));
    }

    @PostMapping
    public ResponseEntity<Produto> createrProduto(@RequestBody ProdutoWriteDTO produtoWriteDTO) {
        return ResponseEntity.ok(produtoService.createProduto(produtoWriteDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> updateProduto(@PathVariable Integer id, @RequestBody ProdutoWriteDTO produtoWriteDTO) {
        Produto updateProduto = produtoService.updateProduto(id, produtoWriteDTO);
        return ResponseEntity.ok(updateProduto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduto(@PathVariable Integer id) {
        produtoService.deleteProduto(id);
        return ResponseEntity.noContent().build();
    }
 }

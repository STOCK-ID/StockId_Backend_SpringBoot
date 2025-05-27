package com.stockid.stockid.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stockid.stockid.Service.ProdutoService;
import com.stockid.stockid.model.Produto;


@RestController
@RequestMapping("api/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public ResponseEntity<List<Produto>> getAllProduct() {
        return ResponseEntity.ok(produtoService.getAllProducts());
    }
}

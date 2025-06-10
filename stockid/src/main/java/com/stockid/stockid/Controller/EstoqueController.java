package com.stockid.stockid.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stockid.stockid.Service.EstoqueService;
import com.stockid.stockid.model.WriteDTOs.EstoqueWriteDTO;

@RestController
@RequestMapping("api/estoque")
public class EstoqueController {

    @Autowired
    EstoqueService estoqueService;

    @PostMapping
    public ResponseEntity createLote(@RequestBody EstoqueWriteDTO estoqueWriteDTO) {
        try {
            return ResponseEntity.ok().body(estoqueService.createLote(estoqueWriteDTO));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity findAllEstoque() {
        try {
            return ResponseEntity.ok().body(estoqueService.findAllEstoque());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}

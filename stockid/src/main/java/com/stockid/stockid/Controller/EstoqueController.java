package com.stockid.stockid.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spec.speedspring.core.controller.GenericRestController;
import com.spec.speedspring.core.responses.GenericResponse;
import com.stockid.stockid.Service.EstoqueService;
import com.stockid.stockid.model.Estoque;
import com.stockid.stockid.model.WriteDTOs.EstoqueWriteDTO;

@RestController
@RequestMapping("api/estoque")
public class EstoqueController extends GenericRestController{

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

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Integer id) {
        try {
            Estoque estoque = estoqueService.findByIdOrThrow(id);

            return ResponseEntity.ok().body(estoque);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
    @PutMapping("/{id_estoque}")
    public ResponseEntity<GenericResponse> updateEstoque(@RequestBody EstoqueWriteDTO estoqueWriteDTO, @PathVariable Integer id_estoque) {
        try {
            Estoque newEstoque = estoqueService.update(estoqueWriteDTO, id_estoque);

            return getResponseOK("Estoque atualizado com sucesso!", newEstoque);

        } catch (Exception e) {
            return getResponseException(e);
        }
    }
}

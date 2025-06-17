package com.stockid.stockid.Controller;


import java.util.List;

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
import com.stockid.stockid.model.DTOs.EstoqueDTO;
import com.stockid.stockid.model.WriteDTOs.EstoqueWriteDTO;

@RestController
@RequestMapping("api/estoque")
public class EstoqueController extends GenericRestController{

    @Autowired
    EstoqueService estoqueService;

    @PostMapping
    public ResponseEntity<GenericResponse> createLote(@RequestBody EstoqueWriteDTO estoqueWriteDTO) {
        try {
            Estoque newEstoque = estoqueService.createLote(estoqueWriteDTO);

            return getResponseOK("Estoque criado com sucesso!", newEstoque.toDTO());
        } catch (Exception e) {
            return getResponseException(e);
        }
    }

    @GetMapping
    public ResponseEntity<GenericResponse> findAllEstoque() {
        try {
            List<EstoqueDTO> estoqueList = estoqueService.findAllEstoque();
            
            return getResponseOK("Lista do estoque:", estoqueList); 
        } catch (Exception e) {
            return getResponseException(e);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<GenericResponse> findById(@PathVariable Integer id) {
        try {
            Estoque estoque = estoqueService.findByIdOrThrow(id);

            return getResponseOK("Estoque encontrado!", estoque.toDTO());
        } catch (Exception e) {
            return getResponseException(e);
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

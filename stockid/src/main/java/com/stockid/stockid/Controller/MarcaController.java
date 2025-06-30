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
import com.stockid.stockid.Service.MarcaService;
import com.stockid.stockid.model.Marca;
import com.stockid.stockid.model.WriteDTOs.MarcaWriteDTO;


@RestController
@RequestMapping("/marca")
public class MarcaController extends GenericRestController{

    @Autowired
    private MarcaService marcaService;

    @GetMapping
    public ResponseEntity<GenericResponse> getAllMarca() {
        try {
            return getResponseOK("Marcas encontradas:", marcaService.getAllMarca());
        } catch (Exception e) {
            return getResponseException(e);
        }
        
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<GenericResponse> getMarcaById(@PathVariable Integer id) {
        try {
            Marca marca = marcaService.getMarcaByIdOrThrow(id);
    
            return getResponseOK("Marca encontrada:", marca.toDTO());
        } catch (Exception e) {
            return getResponseException(e);
        }
    }
    
    @PostMapping
    public ResponseEntity<GenericResponse> createMarca(@RequestBody MarcaWriteDTO marcaWriteDTO) {
        try {
            Marca marca = marcaService.createMarca(marcaWriteDTO);
            
            return getResponseOK("Marca criada com sucesso!", marca.toDTO());
        } catch (Exception e) {
            return getResponseException(e);
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<GenericResponse> updateMarca(@PathVariable Integer id, @RequestBody MarcaWriteDTO marcaWriteDTO) {
        try {
            Marca updateMarca = marcaService.updateMarca(id, marcaWriteDTO);
            
            return getResponseOK("Marca atualizada com sucesso", updateMarca.toDTO());
        } catch (Exception e){
            return getResponseException(e);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<GenericResponse> deleteMarca(@PathVariable Integer id) {
        try {
            Marca marca = marcaService.deleteMarca(id);
            
            return getResponseDeleted("Marca deletada com sucesso!", marca.toDTO());
        } catch (Exception e) {
            return getResponseException(e);
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<GenericResponse> reactivateMarca(@PathVariable Integer id) {
        try {
            Marca marca = marcaService.reactivateMarca(id);
            
            return getResponseOK("Marca reativada com sucesso!", marca.toDTO());
        } catch (Exception e) {
            return getResponseException(e);
        }
    }

}

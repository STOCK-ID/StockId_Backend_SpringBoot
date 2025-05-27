package com.stockid.stockid.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stockid.stockid.Service.MarcaService;
import com.stockid.stockid.model.Marca;
import com.stockid.stockid.model.WriteDTOs.MarcaWriteDTO;


@RestController
@RequestMapping("/marca")
public class MarcaController {

    @Autowired
    private MarcaService marcaService;

    @GetMapping
    public ResponseEntity<List<Marca>> getAllMarca() {
        return ResponseEntity.ok(marcaService.getAllMarca());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Marca> getMarcaById(@PathVariable Integer id) {
        return ResponseEntity.ok(marcaService.getMarcaById(id));
    }
    
    @PostMapping
    public ResponseEntity<Marca> createMarca(@RequestBody MarcaWriteDTO marcaWriteDTO) {
        return ResponseEntity.ok(marcaService.createMarca(marcaWriteDTO));
    }
}

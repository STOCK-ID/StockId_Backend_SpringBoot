package com.stockid.stockid.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stockid.stockid.Repository.MarcaRepository;
import com.stockid.stockid.model.Marca;

@Service
public class MarcaService {
    
    @Autowired
    private MarcaRepository marcaRepository;

    public List<Marca> getAllMarca() {
        return marcaRepository.findAll();
    }

    public Marca getMarcaById(Integer id) {
        return marcaRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Marca not found with id: " + id));
    }
}

package com.stockid.stockid.Service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stockid.stockid.Repository.MarcaRepository;
import com.stockid.stockid.model.Marca;
import com.stockid.stockid.model.DTOs.MarcaDTO;
import com.stockid.stockid.model.WriteDTOs.MarcaWriteDTO;

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

    public Marca createMarca(MarcaWriteDTO marcaWriteDTO) {
        Marca marca = new Marca(marcaWriteDTO.getNome());

        Marca newMarca = marcaRepository.save(marca);

        return newMarca;
    }

    public Marca updateMarca(Integer id, MarcaWriteDTO marcaWriteDTO) {
        Marca lastMarca = getMarcaById(id);

        if(lastMarca.getNome().equals(marcaWriteDTO.getNome())) {
            throw new RuntimeException("Nenhuma alteraçcao foi feita");
        } else {

            lastMarca.setNome(marcaWriteDTO.getNome());
            lastMarca.setLastUpdate(LocalDateTime.now());
            
            Marca updatedMarca = marcaRepository.save(lastMarca);
            return updatedMarca;
        }
    }
}

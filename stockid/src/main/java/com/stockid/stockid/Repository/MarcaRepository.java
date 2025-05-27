package com.stockid.stockid.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stockid.stockid.model.Marca;

public interface MarcaRepository extends JpaRepository<Marca, Integer>{
    
}

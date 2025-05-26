package com.stockid.stockid.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Marca extends IntDomain {

    @Column(unique = false, nullable = false)
    private String nome;
}

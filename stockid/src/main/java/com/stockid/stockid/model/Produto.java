package com.stockid.stockid.model;

import com.stockid.stockid.enums.EnumCategoria;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Produto extends IntDomain {

    @ManyToOne
    @JoinColumn(name = "marca_id", nullable = false, unique = false)
    private Marca marca;

    @Enumerated(EnumType.STRING)
    @Column(name = "categoria", unique = false, nullable = false, length = 50)
    private EnumCategoria categoria;

    @Column(name = "gtin", unique = true, nullable = false, length= 14)
    private String gtin;

    @Column(name = "nome", unique = false, nullable = false, length= 100)
    private String nome;

    @Column(name = "unidade_desc", unique = false, nullable = false, length= 150)
    private String unidadeDesc;
}

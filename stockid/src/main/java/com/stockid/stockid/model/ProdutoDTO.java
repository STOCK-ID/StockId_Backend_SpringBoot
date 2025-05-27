package com.stockid.stockid.model;

import com.stockid.stockid.enums.EnumCategoria;
import com.stockid.stockid.model.DTOs.IntDomainDTO;
import com.stockid.stockid.model.DTOs.MarcaDTO;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ProdutoDTO extends IntDomainDTO {
    private MarcaDTO marca;
    private String nome;
    private String gtin;
    private String unidadeDesc;
    private EnumCategoria categoria;
}

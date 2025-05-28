package com.stockid.stockid.model.WriteDTOs;

import com.stockid.stockid.enums.EnumCategoria;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ProdutoWriteDTO {

    private Integer marcaId;
    private String nome;
    private String gtin;
    private String unidadeDesc;
    private EnumCategoria categoria;
}

package com.stockid.stockid.model.DTOs;

import java.time.LocalDate;

import com.stockid.stockid.enums.EnumStatusLote;
import com.stockid.stockid.model.Produto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class EstoqueDTO extends IntDomainDTO {

    private ProdutoDTO produto;
    private String lote;
    private Integer quantidadeAtual;
    private Integer quantidadeMinima;
    private String unidadeMedida;
    private LocalDate validade;
    private Double precoVenda;
    private EnumStatusLote statusLote;

}

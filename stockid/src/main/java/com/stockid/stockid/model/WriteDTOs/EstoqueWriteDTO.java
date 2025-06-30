package com.stockid.stockid.model.WriteDTOs;

import java.time.LocalDate;

import com.stockid.stockid.enums.EnumStatusLote;

import lombok.Data;

@Data
public class EstoqueWriteDTO {
    private Integer produtoId;
    private String lote;
    private Integer quantidadeAtual;
    private Integer quantidadeMinima;
    private String unidadeMedida;
    private LocalDate validade;
    private LocalDate entrada;
    private Double precoCompra;
    private Double precoVenda;
    private EnumStatusLote statusLote;
}

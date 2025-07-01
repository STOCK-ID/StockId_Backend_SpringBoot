package com.stockid.stockid.model;

import java.time.LocalDate;

import com.spec.speedspring.core.dtoConvertable.DTOConvertable;
import com.stockid.stockid.enums.EnumStatusLote;
import com.stockid.stockid.model.DTOs.EstoqueDTO;
import com.stockid.stockid.model.WriteDTOs.EstoqueWriteDTO;

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

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
public class Estoque extends IntDomain implements DTOConvertable<EstoqueWriteDTO, EstoqueDTO>{

    @ManyToOne
    @JoinColumn(name = "produto_id", nullable = false)
    private Produto produto;

    @Column(nullable = false, unique = true, length = 50)
    private String lote;    

    @Column(nullable = false)
    private Integer quantidadeAtual;

    @Column(nullable = false)
    private Integer quantidadeMinima;

    @Column(nullable = false)
    private String unidadeMedida;

    @Column(name = "dt_validade", nullable = true)
    private LocalDate validade;

    @Column(name = "dt_entrada", nullable = false)
    private LocalDate entrada;

    @Column(nullable = false)
    private Double precoCompra;

    @Column(nullable = false)
    private Double precoVenda;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "statusLote", nullable = false, length = 60)
    private EnumStatusLote statusLote;

    @Override
    public Class<EstoqueDTO> getDTOClass() {
        return EstoqueDTO.class;
    }

    @Override
    public boolean getLog() {
        return false;
    }

    public Estoque (EstoqueWriteDTO estoqueW) {
        initBy(estoqueW);
    }

}

package com.stockid.stockid.model;

import com.spec.speedspring.core.dtoConvertable.DTOConvertable;
import com.stockid.stockid.model.DTOs.MarcaDTO;
import com.stockid.stockid.model.WriteDTOs.MarcaWriteDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Marca extends IntDomain implements DTOConvertable<MarcaWriteDTO, MarcaDTO>{

    @Column(unique = false, nullable = false)
    private String nome;

    @Override
    public Class<MarcaDTO> getDTOClass() {
        return MarcaDTO.class;
    }

    public boolean getLog() {
        return false;
    }


}

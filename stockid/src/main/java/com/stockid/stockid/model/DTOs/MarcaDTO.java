package com.stockid.stockid.model.DTOs;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class MarcaDTO extends IntDomainDTO {

    private String nome;
}

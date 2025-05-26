package com.stockid.stockid.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import com.stockid.stockid.model.DTOs.IntDomainDTO;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

@MappedSuperclass
@Data
public class IntDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Basic
    @CreationTimestamp
    @Column(name = "dt_create", updatable=false)
    private LocalDateTime creationDate = LocalDateTime.now();

    @Basic
    @CreationTimestamp
    @Column(name = "dt_update")
    private LocalDateTime lastUpdate = LocalDateTime.now();

    @Basic
    private boolean active = true;

    public void copyDomainOfIntDomainDTO(IntDomainDTO intDomainDTO) {
        setId(intDomainDTO.getId());
        setCreationDate(intDomainDTO.getCreationDate());
        setLastUpdate(intDomainDTO.getLastUpdate());
        setActive(intDomainDTO.isActive());
    }
}

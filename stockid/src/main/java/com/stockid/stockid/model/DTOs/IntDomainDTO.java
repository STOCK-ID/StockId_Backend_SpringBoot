package com.stockid.stockid.model.DTOs;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

import com.stockid.stockid.model.IntDomain;

import lombok.Data;

@Data
public class IntDomainDTO {

    private Integer id;
    private LocalDateTime creationDate;
    private LocalDateTime lastUpdate;
    private boolean active;

    public void copyDomainOfIntDomainDTO(IntDomain intDomain) {
        this.id = intDomain.getId();
        this.creationDate = intDomain.getCreationDate();
        this.lastUpdate = intDomain.getLastUpdate();
        this.active = intDomain.isActive();
    }

    public String getLastUpdateFormatedDateBR() {
        LocalDateTime lastUpDateTime = this.getLastUpdate();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return lastUpDateTime.format(formatter);
    }

    public Boolean isActive() {
        return this.active;
    }

    public HashMap<String, Object> getDomainDTOMap(HashMap<String, Object> map) {
        map.put("id", this.id);
        map.put("creationDate", this.creationDate);
        map.put("lastUpdate", this.lastUpdate);
        map.put("active", this.active);
        return map;
    }
}

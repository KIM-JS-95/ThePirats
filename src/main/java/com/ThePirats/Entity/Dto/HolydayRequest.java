package com.ThePirats.Entity.Dto;

import com.ThePirats.Entity.Store;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.util.List;


@Data
@Getter
@Builder
public class HolydayRequest {

    private Long Id;

    private List holidays;


    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }


    public List getHolidays() {
        return holidays;
    }

    public void setHolidays(List holidays) {
        this.holidays = holidays;
    }
}

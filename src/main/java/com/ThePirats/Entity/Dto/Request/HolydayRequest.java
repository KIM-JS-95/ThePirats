package com.ThePirats.Entity.Dto.Request;

import com.ThePirats.Entity.Store;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.util.List;


@Data
@Getter

public class HolydayRequest {

    private Long Id;

    private String[] holidays;


    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }


}

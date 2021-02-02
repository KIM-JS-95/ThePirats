package com.ThePirats.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
public class Holidays {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String holyday;

//    @ManyToOne(fetch = FetchType.LAZY)
//    private Store store;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHolyday() {
        return holyday;
    }

    public void setHolyday(String holyday) {
        this.holyday = holyday;
    }

//    public Store getStore() {
//        return store;
//    }
//
//    public void setStore(Store store) {
//        this.store = store;
//    }
}
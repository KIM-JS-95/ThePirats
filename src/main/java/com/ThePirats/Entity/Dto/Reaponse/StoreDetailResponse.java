package com.ThePirats.Entity.Dto.Reaponse;


import com.ThePirats.Entity.Dto.Request.StoreDetailRequest;
import com.ThePirats.Entity.businessTimes;
import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StoreDetailResponse {

    private Long id;

    private String name;

    private String description;

    private int level;

    private String address;

    private String phone;

//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
//    @JoinColumn(name = "store_id", referencedColumnName = "Id")
    private List<StoreDetailRequest> businessDays;

    private ArrayList<String> holidays;

}

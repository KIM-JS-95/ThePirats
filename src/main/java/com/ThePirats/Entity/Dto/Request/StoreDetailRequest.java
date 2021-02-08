package com.ThePirats.Entity.Dto.Request;

import com.ThePirats.Entity.Store;
import com.ThePirats.Entity.businessTimes;
import com.ThePirats.function.SearchRequest;
import com.ThePirats.function.SearchResponse;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StoreDetailRequest {

    private String day;

    private String open;

    private String close;

    private String status ="cc";

    public StoreDetailRequest(businessTimes entity) {
        this.day = entity.getDay();
        this.open = entity.getOpen();
        this.close = entity.getClose();
    }

}

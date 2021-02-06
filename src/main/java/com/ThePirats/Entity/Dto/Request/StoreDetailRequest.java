package com.ThePirats.Entity.Dto.Request;


import com.ThePirats.function.SearchRequest;
import com.ThePirats.function.SearchResponse;
import com.ThePirats.repository.BusinessTimeRepository;
import lombok.Builder;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Data
@Builder
public class StoreDetailRequest{

    @Autowired
   private static BusinessTimeRepository businessTimeRepository;

    private String day;

    private String open;

    private String close;

   // private String status = "sss";



//        List<String> entity = businessTimeRepository.findByStoreId(id);
//        String arr = SearchRequest.nowTime();
//        String status = SearchResponse.Open(arr, entity ,id);


}

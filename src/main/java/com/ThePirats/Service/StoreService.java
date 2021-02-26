package com.ThePirats.Service;

import com.ThePirats.Entity.Dto.Reaponse.StoreDetailResponse;
import com.ThePirats.Entity.Dto.Request.HolydayRequest;
import com.ThePirats.Entity.Dto.Reaponse.StoreApiResponse;
import com.ThePirats.Entity.Dto.Request.StoreDetailRequest;
import com.ThePirats.Entity.businessTimes;
import com.ThePirats.function.SearchRequest;
import com.ThePirats.function.SearchResponse;
import com.ThePirats.Entity.Store;
import com.ThePirats.repository.BusinessTimeRepository;
import com.ThePirats.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class StoreService {

    @Autowired
    private StoreRepository storeRepository;

    @Autowired
    private BusinessTimeRepository businessTimeRepository;

    // Q. A : Saving Store API
    @Transactional
    public Store save(Store store){
        store = storeRepository.save(store);
        return store;
    }

    // Q. B : Saving holiday API
    @Transactional
    public Store saveholiday(HolydayRequest request) {

        Long id = request.getId();
        List<String> holidays = request.getHolidays();

        System.out.println("holidays");
        for (String i : holidays) {
            System.out.println(i);
        }

        Store store=storeRepository.findById(id)
                        .orElseThrow(() -> new IllegalArgumentException("해당 게시슬이 없습니다. id =" +id));

        store.setHolidays((ArrayList<String>) holidays);
        storeRepository.save(store);

        return store;
    }


    // Q. C :  Searching Store index API
    @Transactional
    public StoreApiResponse status(Long id) {
       Store store = storeRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("해당 게시글이 없습니다. id= " + id));

        StoreApiResponse response =StoreApiResponse.builder()
                .name(store.getName())
                .description(store.getDescription())
                .level(store.getLevel())
                .businessStatus(time(id))
                .build();

        return response;
    }

    // Q. D :  Searching detail Store index API
    @Transactional
    public StoreDetailResponse findById(Long id) {
        Store store = storeRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("해당 게시글이 없습니다. id= " + id));

        StoreDetailResponse response =StoreDetailResponse.builder()
                .name(store.getName())
                .description(store.getDescription())
                .level(store.getLevel())
                .address(store.getAddress())
                .phone(store.getPhone())
                .businessDays(Holydaydetail(id))
                .holidays(store.getHolidays())
                .build();

        return response;
    }

    // Q. E : Delete API
    @Transactional
    public void delete(Long id){
        Store store = storeRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("해당 게시글이 없습니다. id= " + id));
        storeRepository.delete(store);
    }


    public List<StoreDetailRequest> Holydaydetail(Long id) {
        List<businessTimes> request = businessTimeRepository.findByDetail(id);

        return request.stream().map( item->{
                    StoreDetailRequest requests= StoreDetailRequest.builder()
                            .day(item.getDay())
                            .open(item.getOpen())
                            .close(item.getClose())
                            .status(time(id))
                            .build();
                            return requests;
                }).collect(Collectors.toList());
    }


// holiyday 저장 버그 개선
    public String time(Long id){
        List<String> entityTime = businessTimeRepository.findByStoreId(id);
        Store  entityDate = storeRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("해당 게시글이 없습니다. id= " + id));

        System.out.println("stream");
        for (String i : entityDate.getHolidays()) {
            System.out.println(i);
        }
        String time= SearchRequest.nowTime();
        String date = SearchRequest.nowdate();
        String arr1 = SearchResponse.Open(time, date,entityTime, entityDate.getHolidays());
        return arr1;
    }

}
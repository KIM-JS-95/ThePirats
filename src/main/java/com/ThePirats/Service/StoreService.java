package com.ThePirats.Service;

import com.ThePirats.Entity.Dto.Reaponse.StoreDetailResponse;
import com.ThePirats.Entity.Dto.Request.HolydayRequest;
import com.ThePirats.Entity.Dto.Reaponse.StoreApiResponse;
import com.ThePirats.Entity.Dto.Request.StoreDetailRequest;
import com.ThePirats.function.SearchRequest;
import com.ThePirats.function.SearchResponse;
import com.ThePirats.Entity.Store;
import com.ThePirats.repository.BusinessTimeRepository;
import com.ThePirats.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class StoreService {

    @Autowired
    private StoreRepository storeRepository;

    @Autowired
    private BusinessTimeRepository businessTimeRepository;

    @Transactional
    public Store save(Store store){
        store = storeRepository.save(store);
        return store;
    }

    @Transactional
    public Store saveholiday(HolydayRequest request) {

        Long id = request.getId();
        String[] holidays = request.getHolidays();

        Store store=storeRepository.findById(id)
                        .orElseThrow(() -> new IllegalArgumentException("해당 게시슬이 없습니다. id =" +id));

        store.setHolidays(holidays);
        storeRepository.save(store);

        return store;
    }


    @Transactional
    public void delete(Long id){
        Store store = storeRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("해당 게시글이 없습니다. id= " + id));
        storeRepository.delete(store);
    }

    @Transactional
    public Store findById(Long id) {
        Store entity = storeRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("해당 게시글이 없습니다. id= " + id));

        return entity;
    }

    @Transactional
    public StoreApiResponse status(Long id) {
       List<String> entity = businessTimeRepository.findByStoreId(id);
       Store store = storeRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("해당 게시글이 없습니다. id= " + id));
        String arr = SearchRequest.nowTime();
        String arr1 = SearchResponse.Open(arr, entity ,id);

        StoreApiResponse response =StoreApiResponse.builder()
                .name(store.getName())
                .description(store.getDescription())
                .level(store.getLevel())
                .businessStatus(arr1)
                .build();

        return response;
    }

    @Transactional
    public StoreDetailResponse detail(Long id) {
        Store store = storeRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("해당 게시글이 없습니다. id= " + id));

        List<StoreDetailRequest> detailRequest = businessTimeRepository.findByDetail(id).stream()
                .map(
                        StoreDetailRequest::new)
                .collect(Collectors.toList());

        StoreDetailResponse response = StoreDetailResponse.builder()
                .id(store.getId())
                .name(store.getName())
                .description(store.getDescription())
                .level(store.getLevel())
                .address(store.getAddress())
                .phone(store.getPhone())
                .businessDays(detailRequest)
                .build();

        return response;
    }

//    private StoreDetailRequest request(Long id){
//
//         businessTimeRepository.findByStoreId(id)
//                 .map(entity -> {
//                     businessTimeRepository.findByStoreId(entity);
//                 return entity;
//                 })
//                 .orElseGet(()-> "ss");
//         return null;
//
//    }

}
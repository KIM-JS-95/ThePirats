package com.ThePirats.Controller;

import com.ThePirats.Entity.Dto.Reaponse.StoreDetailResponse;
import com.ThePirats.Entity.Dto.Request.HolydayRequest;
import com.ThePirats.Entity.Dto.Reaponse.StoreApiResponse;
import com.ThePirats.Entity.Dto.Request.StoreDetailRequest;
import com.ThePirats.Entity.Store;
import com.ThePirats.Service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class EmployeeController {

    private final StoreService storeService;


    // 가게 저장
    @PostMapping("/")
    public Store SaveStore(@RequestBody Store store) {
    Store save = storeService.save(store);
    return save;
    }

    // 휴일 저장
    @PostMapping("/holydays")
    public Store UpdateHolydays(@RequestBody HolydayRequest request) {
        Store save = storeService.saveholiday(request);
        return save;
    }

    // 가게 목록 삭제
    @DeleteMapping("/{id}")
    @ResponseBody
    public Long delete(@PathVariable Long id){
        storeService.delete(id);
        return id;
    }

    //가게 목록 조회
    @GetMapping("{id}")
    public Store findByStoreId(@PathVariable Long id){
        return storeService.findById(id);
    }


    //가게 목록 조회
    @GetMapping("/status/{id}")
    public StoreApiResponse status(@PathVariable Long id){

        // storeService.status(id);

        //System.out.println(time.SearchRequest());
        return storeService.status(id);
    }

    //가게 목록 상세 조회
    @GetMapping("/status/detail/{id}")
    public StoreDetailResponse detail(@PathVariable Long id){

        return storeService.detail(id);
    }
}
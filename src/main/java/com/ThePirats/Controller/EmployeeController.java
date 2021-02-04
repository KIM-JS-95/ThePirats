package com.ThePirats.Controller;

import com.ThePirats.Entity.Dto.HolydayRequest;
import com.ThePirats.Entity.Store;
import com.ThePirats.Entity.businessTimes;
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
    public String status(@PathVariable Long id){


        storeService.status(id);

        //System.out.println(time.SearchRequest());
        return "a";
    }
}
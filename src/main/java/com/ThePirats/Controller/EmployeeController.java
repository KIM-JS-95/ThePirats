package com.ThePirats.Controller;

import com.ThePirats.Entity.Dto.HolydayRequest;
import com.ThePirats.Entity.Store;
import com.ThePirats.Service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class EmployeeController {

    private final StoreService storeService;

    @PostMapping("/")
    public Store SaveStore(@RequestBody Store store) {
    Store save = storeService.save(store);
    return save;
    }

    @PostMapping("/holydays")
    public Store UpdateHolydays(@RequestBody HolydayRequest request) {
        Store save = storeService.saveholiday(request);
        // String[] body=request.getHolidays();
        return save;
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public Long delete(@PathVariable Long id){
        storeService.delete(id);
        return id;
    }

    @GetMapping("{id}")
    public Store findByStoreId(@PathVariable Long id){
        return storeService.findById(id);
    }

}
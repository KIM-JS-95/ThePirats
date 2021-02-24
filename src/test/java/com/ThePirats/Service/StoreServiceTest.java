package com.ThePirats.Service;

import com.ThePirats.Entity.Dto.Request.StoreDetailRequest;
import com.ThePirats.Entity.businessTimes;
import com.ThePirats.repository.BusinessTimeRepository;
import com.ThePirats.repository.StoreRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


public class StoreServiceTest {

    @Autowired
    private BusinessTimeRepository businessTimeRepository;
    @Autowired
    private StoreRepository storeRepository;

//    @Test
//    public void main(String[] args){
//
//        Long id =1L;
//        String[] request = storeRepository.findByHolidays(id);
//        for(String val : request)
//            System.out.println(val);
//    }
}
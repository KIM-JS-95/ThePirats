package com.ThePirats.Service;

import com.ThePirats.Entity.Dto.Request.StoreDetailRequest;
import com.ThePirats.Entity.businessTimes;
import com.ThePirats.repository.BusinessTimeRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;


public class StoreServiceTest {

    @Autowired
    private BusinessTimeRepository businessTimeRepository;

    @Test
    public void main(String[] args){

        Long id =1L;
        businessTimes request = businessTimeRepository.findByDetail(id);
        StoreDetailRequest requests = StoreDetailRequest.builder()
                .day(request.getDay())
                .open(request.getOpen())
                .close(request.getClose())
                .status("today is Open")
                .build();

        System.out.println(requests);
    }
}
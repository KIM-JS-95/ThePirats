package com.ThePirats.Service;

import com.ThePirats.Entity.Dto.Request.StoreDetailRequest;
import com.ThePirats.Entity.businessTimes;
import com.ThePirats.repository.BusinessTimeRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


public class StoreServiceTest {

    @Autowired
    private BusinessTimeRepository businessTimeRepository;

    @Test
    public void main(String[] args){

        Long id =1L;
        List<businessTimes> request = businessTimeRepository.findByDetail(id);
        request.stream().map(StoreDetailRequest::new).collect(Collectors.toList()).forEach(System.out::println);

    }
}
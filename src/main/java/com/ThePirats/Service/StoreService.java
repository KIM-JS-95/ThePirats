package com.ThePirats.Service;

import com.ThePirats.Entity.Dto.HolydayRequest;
import com.ThePirats.Entity.Store;
import com.ThePirats.repository.HolydayRepository;
import com.ThePirats.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service
public class StoreService {

    @Autowired
    private StoreRepository storeRepository;
    @Autowired
    private HolydayRepository holydayRepository;


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

}
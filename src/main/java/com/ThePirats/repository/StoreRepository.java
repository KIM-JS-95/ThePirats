package com.ThePirats.repository;

import com.ThePirats.Entity.Dto.Request.HolydayRequest;
import com.ThePirats.Entity.Dto.Request.StoreDetailRequest;
import com.ThePirats.Entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface StoreRepository extends JpaRepository<Store, Long> {

   // StoreDetailRequest findByBusinessTimes(Long id);

    @Modifying
    @Query(value = "select HOLIDAYS from store where id= :id", nativeQuery = true)
    ArrayList<String> findByHolidays(Long id);
}

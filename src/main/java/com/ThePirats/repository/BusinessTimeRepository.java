package com.ThePirats.repository;

import com.ThePirats.Entity.Dto.Request.StoreDetailRequest;
import com.ThePirats.Entity.businessTimes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BusinessTimeRepository extends JpaRepository<businessTimes, Long> {

    @Modifying
    @Query(value = "select * from business_Times where store_id= :id", nativeQuery = true)
    List<String> findByStoreId(Long id);


    @Modifying
    @Query(value = "select * from business_Times where store_id= :id", nativeQuery = true)
    List<businessTimes> findByDetail(Long id);

}

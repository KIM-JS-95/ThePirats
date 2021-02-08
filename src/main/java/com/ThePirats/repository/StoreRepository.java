package com.ThePirats.repository;

import com.ThePirats.Entity.Dto.Request.StoreDetailRequest;
import com.ThePirats.Entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreRepository extends JpaRepository<Store, Long> {

    StoreDetailRequest findByBusinessTimes(Long id);
}

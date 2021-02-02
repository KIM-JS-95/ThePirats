package com.ThePirats.repository;

import com.ThePirats.Entity.Holidays;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HolydayRepository extends JpaRepository<Holidays, Long> {
}

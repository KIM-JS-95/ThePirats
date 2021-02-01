package com.ThePirats.repository;

import com.ThePirats.Entity.Holydays;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HolydayRepository extends JpaRepository<Holydays, Long> {
}

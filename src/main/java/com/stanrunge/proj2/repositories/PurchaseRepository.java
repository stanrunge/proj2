package com.stanrunge.proj2.repositories;

import com.stanrunge.proj2.data.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseRepository extends JpaRepository<Purchase, Long> {
}
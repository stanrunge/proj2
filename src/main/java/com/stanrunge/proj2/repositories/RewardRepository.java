package com.stanrunge.proj2.repositories;

import com.stanrunge.proj2.data.Reward;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RewardRepository extends JpaRepository<Reward, Long> {
}
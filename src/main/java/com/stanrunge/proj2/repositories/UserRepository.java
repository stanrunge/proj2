package com.stanrunge.proj2.repositories;

import com.stanrunge.proj2.data.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}

package com.stanrunge.proj2.repositories;

import com.stanrunge.proj2.data.Submission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubmissionRepository extends JpaRepository<Submission, Long> {
}
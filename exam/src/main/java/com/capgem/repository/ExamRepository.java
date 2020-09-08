package com.capgem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgem.entity.Exam;

@Repository
public interface ExamRepository extends JpaRepository<Exam, Integer> {}

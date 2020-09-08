package com.capgem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgem.entity.ExamProtocol;

import javax.transaction.Transactional;

@Repository
public interface ExamProtocolRepository extends JpaRepository<ExamProtocol, Integer> {}

package com.capgem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgem.entity.Exam;
import com.capgem.entity.Question;

import java.util.List;
import java.util.Set;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {
    List<Question> findByExam(Exam exam);

    List<Question> findByExamId(Integer examId);

    // find first not answered question by exam
    

    int countByExam(Exam exam);
}

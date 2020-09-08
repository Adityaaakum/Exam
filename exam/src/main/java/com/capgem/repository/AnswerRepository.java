package com.capgem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgem.entity.Answer;
import com.capgem.entity.Question;

import java.util.List;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Integer> {
    List<Answer> findByQuestion(Question question);

    List<Answer> findByQuestionId(Integer questionId);

    List<Answer> findByQuestionExamIdAndCorrect(Integer examId, Boolean isCorrect);
}

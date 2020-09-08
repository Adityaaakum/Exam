package com.capgem.service;

import com.capgem.entity.Answer;
import com.capgem.entity.Exam;
import com.capgem.entity.ExamProtocol;
import com.capgem.entity.Question;
import com.capgem.repository.AnswerRepository;
import com.capgem.repository.ExamProtocolRepository;
import com.capgem.repository.ExamRepository;
import com.capgem.repository.QuestionRepository;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ExamService {
    public static final double MAX_GRADE = 100; // 100 points

    @Autowired
    private ExamRepository examRepo;

    @Autowired
    private QuestionRepository questionRepo;

    @Autowired
    private AnswerRepository answerRepo;

    @Autowired
    private ExamProtocolRepository protocolRepo;

    public Exam getRandomExam() {
        final int examCount = (int) examRepo.count();
       
        final int examNumber = new Random().nextInt(examCount);
        return examRepo.findAll().get(examNumber);
    }

    @Transactional
    public int insertExam(ExamProtocol protocol) {
        final ExamProtocol p = protocolRepo.save(protocol);
        protocolRepo.flush();
        return protocol.getId();
    }

    @Transactional
    public ExamProtocol updateExamProtocol(ExamProtocol protocol) {
        return protocolRepo.save(protocol);
    }

    public Exam getExam(int examId) {
        final Exam exam = examRepo.findOne(examId);
        return exam;
    }

    public ExamProtocol getExamProtocol(int protocolId) {
        return protocolRepo.findOne(protocolId);
    }


    public List<Question> getQuestionsForExam(int examId) {
        final List<Question> questions = questionRepo.findByExamId(examId);
        return questions;
    }

    public List<Answer> getAnswersForQuestion(int questionId) {
        final List<Answer> answers = answerRepo.findByQuestionId(questionId);
        return answers;
    }

    

   
    public void calcGrade(ExamProtocol protocol, int examId, List<Integer> userAnswers) {
        if (protocol == null || userAnswers == null) {
            throw new IllegalArgumentException("Invalid parameters on GRADE call");
        }

        final List<Answer> correctAnswers = answerRepo.findByQuestionExamIdAndCorrect(examId, true);
        if (correctAnswers.size() == 0) {
            throw new IllegalArgumentException("You must specify correct answers!");
        }

        final float step = (float) (MAX_GRADE / correctAnswers.size());
        final Set<Integer> correctCount = new HashSet<>();
        final Set<Integer> incorrectCount = new HashSet<>();

        final Set<Integer> answers = userAnswers.stream().filter(a -> a > 0).collect(Collectors.toSet());

        float grade = 0;
        for (final Answer answer : correctAnswers) {
            final Integer id = answer.getId();
            if (answers.contains(id)) {
                grade += step;
                correctCount.add(id);
            } else {
                incorrectCount.add(id);
            }
        }
        // fix for multi-answers questions
        correctCount.removeAll(incorrectCount);

        // grade
        protocol.setCorrectAnswers(correctCount.size());
        protocol.setGrade(Math.round(grade));
    }

 

}

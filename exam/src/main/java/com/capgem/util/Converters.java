package com.capgem.util;

import com.capgem.dto.EntryDTO;
import com.capgem.dto.QuestionDTO;
import com.capgem.entity.Answer;
import com.capgem.entity.Question;

import java.util.List;
import java.util.stream.Collectors;

public class Converters {
    public static List<QuestionDTO> questionsToDTO(List<Question> questions) {
        return questions.stream().map(q -> new QuestionDTO(q)).collect(Collectors.toList());
    }
    
    public static List<EntryDTO> answersToDTO(List<Answer> answers) {
        return answers.stream().map(q -> new EntryDTO(q.getId(), q.getName())).collect(Collectors.toList());
    }
}

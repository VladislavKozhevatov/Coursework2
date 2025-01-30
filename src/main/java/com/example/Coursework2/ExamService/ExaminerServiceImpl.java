package com.example.Coursework2.ExamService;


import com.example.Coursework2.Models.Question;
import com.example.Coursework2.exeptions.OverflowQuestionLimitExeption;
import com.example.Coursework2.interfaces.ExaminerService;
import com.example.Coursework2.interfaces.QuestionService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private JavaQuestionService javaQuestionService;

    private final Random random = new Random();

    public ExaminerServiceImpl(JavaQuestionService javaQuestionService) {
        this.javaQuestionService = javaQuestionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) throws OverflowQuestionLimitExeption {
        int size = javaQuestionService.getAll().size();
        if (size < amount) {
            throw new OverflowQuestionLimitExeption("Запрошенное кол-во вопросов больше чем есть в базе");
        }
        Set<Question> listQuestions = new HashSet<>();

        while (listQuestions.size() < amount) {
            listQuestions.add(javaQuestionService.getRandomQuestion());
        }
//        return new ArrayList<>(listQuestions);
        return listQuestions;
    }
}

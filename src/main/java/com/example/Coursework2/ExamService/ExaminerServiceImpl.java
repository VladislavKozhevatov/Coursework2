package com.example.Coursework2.ExamService;


import com.example.Coursework2.Models.Question;
import com.example.Coursework2.exeptions.overflowQuestionLimitExeption;
import com.example.Coursework2.interfaces.ExaminerService;
import com.example.Coursework2.interfaces.QuestionService;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService {

  private  JavaQuestionService javaQuestionService;
//  private final QuestionService javaQuestionService;
  private final Random random = new Random();

//    public ExaminerServiceImpl(QuestionService javaQuestionService) {
//        this.javaQuestionService = javaQuestionService;
//    }

    public ExaminerServiceImpl(JavaQuestionService javaQuestionService) {
        this.javaQuestionService = javaQuestionService;
    }

//     public ExaminerServiceImpl(QuestionService questionService) {
//            this.javaQuestionService = questionService;
//        }

    @Override
    public Collection<Question> getQuestions(int amount) throws overflowQuestionLimitExeption {
        int size = javaQuestionService.getAll().size();
        if (size<amount){
           throw new overflowQuestionLimitExeption ("Запрошенное кол-во вопросов больше чем есть в базе");
        }
        Set<Question> listQuestions = new HashSet<>();

        while (listQuestions.size()<amount){
            listQuestions.add(javaQuestionService.getRandomQuestion());
        }
        return new ArrayList<>(listQuestions);
  }
}

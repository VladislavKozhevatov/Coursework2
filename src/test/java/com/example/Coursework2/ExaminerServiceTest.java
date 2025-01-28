package com.example.Coursework2;

import com.example.Coursework2.ExamService.ExaminerServiceImpl;
import com.example.Coursework2.ExamService.JavaQuestionService;
import com.example.Coursework2.Models.Question;
import com.example.Coursework2.interfaces.QuestionService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@ExtendWith(MockitoExtension.class)
public class ExaminerServiceTest {

    @Mock
    private QuestionService questionService;
    @Mock
    private JavaQuestionService javaQuestionService;

    @InjectMocks
    private ExaminerServiceImpl examinerService;

    @Test
    void  shouldCorrectGetRandomQuestion(){

        //given

        int amount = 3;

        List<Question> questions = new ArrayList<>();
        questions.add(new Question("Переменная это-", "ячейка хранящая в себе данные"));
        questions.add(new Question("Переменная это-", "ячейка хранящая в себе данные"));
        questions.add(new Question("Переменная это-", "ячейка хранящая в себе данные"));


        Mockito.when(questionService.getAll()).thenReturn(questions);

        //when
        Collection<Question> randomQuestions = examinerService.getQuestions(amount);

        //then

        Assertions.assertEquals(randomQuestions.size(),amount);
        Assertions.assertTrue(randomQuestions.contains(questions));

    }
}

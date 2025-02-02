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

import java.util.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class ExaminerServiceTest {

    @Mock
    private QuestionService questionService;
    @Mock
    private JavaQuestionService javaQuestionService;
    @InjectMocks
    private ExaminerServiceImpl examinerService;

    @Test
    void shouldCorrectGetRandomQuestion() {

        int amount = 3;

        List<Question> questions = new ArrayList<>();
        questions.add(new Question("Переменная это-", "ячейка хранящая в себе данные"));
        questions.add(new Question("ООП это-", "Объектно-ориентированное программирование"));
        questions.add(new Question("Java-", "это язык программирования"));

        Mockito.when(javaQuestionService.getAll()).thenReturn(questions);

        Collection<Question> randomQuestions = examinerService.getQuestions(amount);

        Assertions.assertEquals(randomQuestions.size(), amount);
    }
}

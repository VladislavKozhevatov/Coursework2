package com.example.Coursework2;

import com.example.Coursework2.ExamService.JavaQuestionService;
import com.example.Coursework2.Models.Question;
import com.example.Coursework2.interfaces.QuestionService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Service;

import java.util.*;

public class JavaQuestionServiceTest {

    private QuestionService questionService;


    @BeforeEach
    public void clear() {
        questionService = new JavaQuestionService();
    }

    @Test
    public void getAll() {
        Question question = new Question("Переменная это-", "ячейка хранящая в себе данные");
        Question question2 = new Question("Типы данных в Java-", "Примитивные и объекты");
        Question question3 = new Question("ООП это", "Объектно-ориентированное програмирование");
        questionService.add(question);
        questionService.add(question2);
        questionService.add(question3);
        Set<Question> expected = new HashSet<>() {{
            add(question);
            add(question2);
            add(question3);
        }};

        Collection<Question> actual = questionService.getAll();

        Assertions.assertTrue(expected.containsAll(actual));
    }


    @Test
    public void correctAddQuestion() {

        Question questionToAdd = new Question("Переменная это-", "ячейка хранящая в себе данные");

        Question addedQuestion = questionService.add(questionToAdd);

        Assertions.assertEquals(questionToAdd, addedQuestion);
    }


    @Test
    public void getRandomQuestion() {
        Question question = new Question("Переменная это-", "ячейка хранящая в себе данные");
        Question question2 = new Question("Типы данных в Java-", "Примитивные и объекты");
        Question question3 = new Question("ООП это", "Объектно-ориентированное програмирование");
        questionService.add(question);
        questionService.add(question2);
        questionService.add(question3);
        Set<Question> questions = new HashSet<>() {{
            add(question);
            add(question2);
            add(question3);
        }};

        Question randomQuestion = questionService.getRandomQuestion();

        Assertions.assertTrue(questions.contains(randomQuestion));
    }

    @Test
    public void remove() {

        Question expectedRemovedQuestion = questionService.add("Переменная это-", "ячейка хранящая в себе данные");

        Question actualRemovedQuestion = questionService.remove(expectedRemovedQuestion);

        Assertions.assertEquals(actualRemovedQuestion, expectedRemovedQuestion);
    }
}

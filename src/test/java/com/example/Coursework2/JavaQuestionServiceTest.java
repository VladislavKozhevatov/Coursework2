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

    private  QuestionService questionService ;


    @BeforeEach
    public void clear(){
     questionService = new JavaQuestionService();
    }

    @Test
    public void getAll(){
        //создаем тестовые данные

                 Question question = new Question("Переменная это-", "ячейка хранящая в себе данные");
                 Question question2 = new Question("Типы данных в Java-", "Примитивные и объекты");
                 Question question3 = new Question("ООП это", "Объектно-ориентированное програмирование");

                 questionService.add(question);
                 questionService.add(question2);
                 questionService.add(question3);
        //создаем список expected и заполняем его данными нашего метода
       // List<Question> expected = new ArrayList<>();
        Set<Question> expected = new HashSet<>(){{
            add(question);
            add(question2);
            add(question3);
        }};


        Collection<Question> actual = questionService.getAll();

        ////запускаем тест, в случае если список expected и actual не будут равны
        ////тест будет провален, о результатах теста читаем в консоли
        Assertions.assertTrue(expected.containsAll(actual));
    }


    @Test
    public void correctAddQuestion(){
        //given
        Question questionToAdd = new Question("Переменная это-", "ячейка хранящая в себе данные");

        //when
        Question addedQuestion = questionService.add(questionToAdd);

        //then
        Assertions.assertEquals(questionToAdd,addedQuestion);

    }


    @Test
    public void getRandomQuestion(){

        //given
        Question question = new Question("Переменная это-", "ячейка хранящая в себе данные");
        Question question2 = new Question("Типы данных в Java-", "Примитивные и объекты");
        Question question3 = new Question("ООП это", "Объектно-ориентированное програмирование");

        questionService.add(question);
        questionService.add(question2);
        questionService.add(question3);

        Set<Question> questions = new HashSet<>(){{
            add(question);
            add(question2);
            add(question3);
        }};
        //when
        Question randomQuestion = questionService.getRandomQuestion();

        //then
        Assertions.assertTrue(questions.contains(randomQuestion));
    }

    @Test
    public void remove(){

        //given
        Question expectedRemovedQuestion = questionService.add("Переменная это-", "ячейка хранящая в себе данные");


        //when
        Question actualRemovedQuestion = questionService.remove(expectedRemovedQuestion);

        //then
        Assertions.assertEquals(actualRemovedQuestion,expectedRemovedQuestion);
    }
}

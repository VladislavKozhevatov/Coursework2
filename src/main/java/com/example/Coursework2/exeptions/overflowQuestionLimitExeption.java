package com.example.Coursework2.exeptions;

public class overflowQuestionLimitExeption extends RuntimeException {
    public overflowQuestionLimitExeption(String message) {

        super("Запрошенное уол-во вопросов больше имеющихся в списке");
    }
}

package com.example.Coursework2.exeptions;

public class OverflowQuestionLimitExeption extends RuntimeException {
    public OverflowQuestionLimitExeption(String message) {

        super("Запрошенное уол-во вопросов больше имеющихся в списке");
    }
}

package com.example.Coursework2.interfaces;

import com.example.Coursework2.Models.Question;

import java.util.Collection;

public interface ExaminerService {

     Collection<Question> getQuestions (int amount);
}

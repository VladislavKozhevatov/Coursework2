package com.example.Coursework2.ExamController;

import com.example.Coursework2.ExamService.JavaQuestionService;
import com.example.Coursework2.interfaces.QuestionService;
import com.example.Coursework2.Models.Question;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;

@RestController
@RequestMapping("/exam")
public class JavaQuestionController {

    //  private final QuestionService javaQuestionService;
    QuestionService questionService;
    JavaQuestionService javaQuestionService;


    @GetMapping("/java/add")
    public Question addQuestion(@RequestParam String question, @RequestParam String answer) {
        Question newQuestion = new Question(question, answer);
        questionService.add(question, answer);
        return newQuestion;
    }

    @GetMapping("/java")
    public Collection<Question> getQuestions() {
        return new ArrayList<>(javaQuestionService.getAll());
    }

    @GetMapping("/java/remove")
    public Question removeQuestion(@RequestParam String question, @RequestParam String answer) {
        return questionService.remove(new Question(question, answer));
    }

}

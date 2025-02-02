package com.example.Coursework2.ExamController;

import com.example.Coursework2.ExamService.ExaminerServiceImpl;
import com.example.Coursework2.Models.Question;
import com.example.Coursework2.exeptions.OverflowQuestionLimitExeption;
import com.example.Coursework2.interfaces.ExaminerService;
import com.example.Coursework2.interfaces.QuestionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collection;


@RestController
@RequestMapping("/exam")
public class ExamController {

    private ExaminerService examinerService;

    public ExamController(ExaminerServiceImpl examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping("/{amount}")
    public Collection<Question> getQuestions(@PathVariable int amount) throws OverflowQuestionLimitExeption {
        Collection<Question> amountQuestions = examinerService.getQuestions(amount);
        return amountQuestions;
    }
}

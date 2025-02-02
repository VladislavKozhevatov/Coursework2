package com.example.Coursework2.ExamService;

import com.example.Coursework2.Models.Question;
import com.example.Coursework2.interfaces.QuestionService;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class JavaQuestionService implements QuestionService {

    private final Set<Question> JavaQuestions = new HashSet<>();
    private final Random random = new Random();


    @Override
    public Question add(String question, String answer) {
        Question newQuestion = new Question(question, answer);
        if (question == null || answer == null) {
            throw new RuntimeException("Вы задали пустое поле вопрос/ответ");
        }
        if (JavaQuestions.contains(question)) {
            throw new RuntimeException("Такой вопрос уже содержится в списке");
        }
        JavaQuestions.add(newQuestion);
        return newQuestion;
    }


    @Override
    public Question add(Question question) {
        JavaQuestions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        boolean isRemoved = JavaQuestions.remove(question);
        if (isRemoved) {
            return question;
        } else {
            return null;
        }
    }

    @Override
    public Collection<Question> getAll() {
        return new ArrayList<>(JavaQuestions);
    }

    @Override
    public Question getRandomQuestion() {
        List<Question> listJavaQuestions = new ArrayList<>(JavaQuestions);
        int numberOfQuestion = random.nextInt(getAll().size());
        return listJavaQuestions.get(numberOfQuestion);
    }
}

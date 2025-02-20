package com.question.controller;

import com.question.entities.Question;
import com.question.services.QuestionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {

    private QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    //create
    @PostMapping
    public Question create(@RequestBody Question question) {
        return questionService.create(question);
    }

    //getAll
    @GetMapping
    public List<Question> getAll() {
        return questionService.get();
    }

    //getOne
    @GetMapping("/{questionId}")
    public Question getOne(@PathVariable long questionId) {
        return questionService.getOne(questionId);
    }

    //Get all questions for a specific quizId
    @GetMapping("/quiz/{quizId}")
    public List<Question> getQuestionsOfQuiz(@PathVariable Long quizId) {
        return questionService.getQuestionsOfQuiz(quizId);
    }

}

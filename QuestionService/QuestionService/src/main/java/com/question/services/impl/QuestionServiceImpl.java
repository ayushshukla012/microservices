package com.question.services.impl;

import com.question.entities.Question;
import com.question.repositories.QuestionRepository;
import com.question.services.QuestionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    private QuestionRepository repo;

    public QuestionServiceImpl(QuestionRepository repo) {
        this.repo = repo;
    }

    @Override
    public Question create(Question question) {
        return repo.save(question);
    }

    @Override
    public List<Question> get() {
        return repo.findAll();
    }

    @Override
    public Question getOne(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Question not found"));
    }

    @Override
    public List<Question> getQuestionsOfQuiz(Long quizId) {
        return repo.findByQuizId(quizId);
    }
}

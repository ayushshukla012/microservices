package com.quiz.services.impl;

import com.quiz.entities.Quiz;
import com.quiz.repositories.QuizRepository;
import com.quiz.services.QuestionClient;
import com.quiz.services.QuizService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuizServiceImpl implements QuizService {

    private QuizRepository quizRepository;

    private QuestionClient questionClient;

//    public QuizServiceImpl(QuizRepository quizRepository) {
//        this.quizRepository = quizRepository;
//    }


    public QuizServiceImpl(QuizRepository quizRepository, QuestionClient questionClient) {
        this.quizRepository = quizRepository;
        this.questionClient = questionClient;
    }

    @Override
    public Quiz add(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    /*
    When you have only 1 database and need to find all the values for that field use below code
    @Override
    public List<Quiz> get() {
        return quizRepository.findAll();
    }
    */

    /*
    * It collects all the quiz from quiz table, then collects all questions related to that quiz
    * based on the getId from quiz.
    * Lastly return a quiz list or map which contains questions for that quiz id.
    * */
    @Override
    public List<Quiz> get() {
        List<Quiz> quizzes = quizRepository.findAll();

        List<Quiz> newQuizList = quizzes.stream().map(quiz -> {
            quiz.setQuestions(questionClient.getQuestionOfQuiz(quiz.getId()));
            return quiz;
        }).collect(Collectors.toList());

        return newQuizList;
    }

    /*
    The below code is when to get 1 quiz from quiz table based on the quizId provided.
    @Override
    public Quiz get(Long id) {
        return quizRepository.findById(id).orElseThrow(() -> new RuntimeException("Quiz not found."));
    }
    */

    @Override
    public Quiz get(Long id) {
        Quiz quiz = quizRepository.findById(id).orElseThrow(() -> new RuntimeException("Quiz not found."));
        quiz.setQuestions(questionClient.getQuestionOfQuiz(quiz.getId()));
        return quiz;
    }
}

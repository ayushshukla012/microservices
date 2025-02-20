package com.question.repositories;

import com.question.entities.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long> {

    //For a "quizID" give me all the question from question table
    List<Question> findByQuizId(Long quizId);
}

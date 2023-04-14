package org.senai.semana11.quizzes.repositories;

import org.senai.semana11.quizzes.QuizzesApplication;
import org.senai.semana11.quizzes.models.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Integer> {
}

package org.senai.semana11.quizzes.repositories;

import org.senai.semana11.quizzes.models.Quiz;
import org.senai.semana11.quizzes.models.Resposta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RespostaRepository extends JpaRepository<Resposta, Integer> {
    Resposta findById(int id);
}

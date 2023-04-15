package org.senai.semana11.quizzes.repositories;

import org.senai.semana11.quizzes.models.Pergunta;
import org.senai.semana11.quizzes.models.Resposta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PerguntaRepository extends JpaRepository<Pergunta, Integer> {
    Pergunta findById(int id);

    @Query("SELECT p FROM Pergunta p WHERE p.quiz.nome = :nomeQuiz")
    List<Pergunta> findByNomeDoQuiz(@Param("nomeQuiz") String nomeQuiz);
}

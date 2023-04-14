package org.senai.semana11.quizzes.repositories;

import org.senai.semana11.quizzes.models.Pergunta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerguntaRepository extends JpaRepository<Pergunta, Integer> {
}

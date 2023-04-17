package org.senai.semana11.quizzes.repositories;

import org.senai.semana11.quizzes.models.Pergunta;
import org.senai.semana11.quizzes.models.Quiz;
import org.senai.semana11.quizzes.models.Resposta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RespostaRepository extends JpaRepository<Resposta, Integer> {
    //Resposta findById(int id);

    List<Resposta> findByPergunta(Pergunta categoria);
}

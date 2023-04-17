package org.senai.semana11.quizzes.services;

import jakarta.persistence.EntityNotFoundException;
import org.senai.semana11.quizzes.dtos.*;
import org.senai.semana11.quizzes.mappers.PerguntaMapper;
import org.senai.semana11.quizzes.models.Pergunta;
import org.senai.semana11.quizzes.models.Quiz;
import org.senai.semana11.quizzes.repositories.PerguntaRepository;
import org.senai.semana11.quizzes.repositories.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerguntaService {
    @Autowired
    private PerguntaRepository perguntaRepository;
    @Autowired
    private QuizRepository quizRepository;

    @Autowired
    private PerguntaMapper mapper;
    public PerguntaResponse busca(int id) {
        return mapper.map(perguntaRepository.findById(id).orElseThrow(EntityNotFoundException::new));
    }

    public List<PerguntaResponse> busca(PerguntaGetRequest requestParams) {
        if (requestParams.getNomeQuiz() != null) {
            return mapper.map(perguntaRepository.findByNomeDoQuiz(requestParams.getNomeQuiz()));
        }
        return mapper.map(perguntaRepository.findAll());
    }

    public Pergunta cadastra(PerguntaRequest perguntaRequest) {
        Pergunta pergunta = mapper.map(perguntaRequest);
        perguntaRepository.save(pergunta);
        return pergunta;
    }

    public void atualiza(PerguntaPutRequest request){
        Pergunta pergunta = perguntaRepository.findById(request.getId()).orElseThrow(EntityNotFoundException::new);

        if (request.getTexto() != null && request.getTexto().length() > 0) {
            pergunta.setTexto(request.getTexto());
        }
        if (request.getTitulo() != null && request.getTitulo().length() > 0) {
            pergunta.setTitulo(request.getTitulo());
        }
        if (request.getQuizId() != null) {
            Quiz quiz = quizRepository.findById(request.getQuizId()).orElseThrow(RuntimeException::new);
            pergunta.setQuiz(quiz);
        }

        perguntaRepository.save(pergunta);
    }

    public void excluir(int id) {
        perguntaRepository.deleteById(id);
    }
}

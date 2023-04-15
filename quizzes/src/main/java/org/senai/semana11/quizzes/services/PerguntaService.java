package org.senai.semana11.quizzes.services;

import org.senai.semana11.quizzes.dtos.PerguntaGetRequest;
import org.senai.semana11.quizzes.dtos.PerguntaResponse;
import org.senai.semana11.quizzes.dtos.QuizResponse;
import org.senai.semana11.quizzes.dtos.RespostaResponse;
import org.senai.semana11.quizzes.mappers.PerguntaMapper;
import org.senai.semana11.quizzes.mappers.QuizMapper;
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
    private PerguntaMapper mapper;
    public PerguntaResponse busca(int id) {
        return mapper.map(perguntaRepository.findById(id));
    }

    public List<PerguntaResponse> busca(PerguntaGetRequest requestParams) {
        if (requestParams.getNomeQuiz() != null) {
            return mapper.map(perguntaRepository.findByNomeDoQuiz(requestParams.getNomeQuiz()));
        }
        return mapper.map(perguntaRepository.findAll());
    }
}

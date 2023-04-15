package org.senai.semana11.quizzes.services;

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
    public List<PerguntaResponse> getAllPerguntas(){
        return mapper.map(perguntaRepository.findAll());
    }
    public PerguntaResponse busca(int id) {
        return mapper.map(perguntaRepository.findById(id));
    }
}

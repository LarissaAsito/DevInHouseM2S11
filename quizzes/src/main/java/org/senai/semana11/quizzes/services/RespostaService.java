package org.senai.semana11.quizzes.services;

import org.senai.semana11.quizzes.dtos.PerguntaResponse;
import org.senai.semana11.quizzes.dtos.QuizResponse;
import org.senai.semana11.quizzes.dtos.RespostaResponse;
import org.senai.semana11.quizzes.mappers.PerguntaMapper;
import org.senai.semana11.quizzes.mappers.RespostaMapper;
import org.senai.semana11.quizzes.repositories.PerguntaRepository;
import org.senai.semana11.quizzes.repositories.RespostaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RespostaService {
    @Autowired
    private RespostaRepository respostaRepository;

    @Autowired
    private RespostaMapper mapper;
    public List<RespostaResponse> getAllRespostas(){
        return mapper.map(respostaRepository.findAll());
    }

    public RespostaResponse busca(int id) {
        return mapper.map(respostaRepository.findById(id));
    }
}

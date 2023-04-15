package org.senai.semana11.quizzes.services;

import org.senai.semana11.quizzes.dtos.*;
import org.senai.semana11.quizzes.mappers.PerguntaMapper;
import org.senai.semana11.quizzes.mappers.RespostaMapper;
import org.senai.semana11.quizzes.models.Pergunta;
import org.senai.semana11.quizzes.models.Quiz;
import org.senai.semana11.quizzes.models.Resposta;
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
    private PerguntaRepository perguntaRepository;
    @Autowired
    private RespostaMapper mapper;
    public List<RespostaResponse> getAllRespostas(){
        return mapper.map(respostaRepository.findAll());
    }

    public RespostaResponse busca(int id) {
        return mapper.map(respostaRepository.findById(id));
    }

    public List<RespostaResponse> busca(RespostaGetRequest requestParams) {
        if (requestParams.getPerguntaId() != null) {
            Pergunta pergunta = new Pergunta();
            pergunta.setId(requestParams.getPerguntaId());
            return mapper.map(respostaRepository.findByPergunta(pergunta));
        }
        return mapper.map(respostaRepository.findAll());
    }

    public void cadastra(RespostaRequest respostaRequest) {
        Resposta resposta = mapper.map(respostaRequest);
        respostaRepository.save(resposta);
    }

    public void atualiza(RespostaPutRequest request){
        Resposta resposta = respostaRepository.findById(request.getId());

        if (request.getTexto() != null && request.getTexto().length() > 0) {
            resposta.setTexto(request.getTexto());
        }
        if (request.getPerguntaId() != null) {
            Pergunta quiz = perguntaRepository.findById(request.getPerguntaId()).orElseThrow(RuntimeException::new);
            resposta.setPergunta(quiz);
        }

        respostaRepository.save(resposta);
    }
}

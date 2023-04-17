package org.senai.semana11.quizzes.services;

import org.senai.semana11.quizzes.dtos.QuizPutRequest;
import org.senai.semana11.quizzes.dtos.QuizRequest;
import org.senai.semana11.quizzes.dtos.QuizResponse;
import org.senai.semana11.quizzes.mappers.QuizMapper;
import org.senai.semana11.quizzes.models.Quiz;
import org.senai.semana11.quizzes.repositories.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
public class QuizService {
    @Autowired
    private QuizRepository quizRepository;

    @Autowired
    private QuizMapper mapper;
    public List<QuizResponse> getAllQuizzes(){
        return mapper.map(quizRepository.findAll());
    }

    public QuizResponse busca(int id) {
        Quiz quiz = quizRepository.findById(id).orElseThrow(EntityNotFoundException::new);

        return mapper.map(quiz);
    }

    public void cadastra(QuizRequest quizRequest) {
        Quiz quiz = mapper.map(quizRequest);
        quizRepository.save(quiz);
    }

    public void atualiza(QuizPutRequest request){
        Quiz quiz = quizRepository.findById(request.getId()).orElseThrow(EntityNotFoundException::new);

        if (request.getNome() != null && request.getNome().length() > 0) {
            quiz.setNome(request.getNome());
        }
        if (request.getDescricao() != null && request.getDescricao().length() > 0) {
            quiz.setDescricao(request.getDescricao());
        }

        quizRepository.save(quiz);
    }

    public void excluir(int id) {
        quizRepository.deleteById(id);
    }
}

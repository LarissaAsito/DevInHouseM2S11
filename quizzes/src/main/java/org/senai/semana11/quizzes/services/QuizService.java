package org.senai.semana11.quizzes.services;

import org.senai.semana11.quizzes.dtos.QuizRequest;
import org.senai.semana11.quizzes.dtos.QuizResponse;
import org.senai.semana11.quizzes.mappers.QuizMapper;
import org.senai.semana11.quizzes.models.Quiz;
import org.senai.semana11.quizzes.repositories.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        return mapper.map(quizRepository.findById(id));
    }

    public void cadastra(QuizRequest quizRequest) {
        Quiz quiz = mapper.map(quizRequest);
        quizRepository.save(quiz);
    }
}

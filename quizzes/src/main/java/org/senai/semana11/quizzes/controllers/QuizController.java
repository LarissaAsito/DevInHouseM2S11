package org.senai.semana11.quizzes.controllers;

import org.senai.semana11.quizzes.dtos.QuizResponse;
import org.senai.semana11.quizzes.models.Quiz;
import org.senai.semana11.quizzes.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    private QuizService quizService;
    @GetMapping
    public List<QuizResponse> listarQuizzes() {
        return quizService.getAllQuizzes();
    }

    @GetMapping("/{id}")
    public QuizResponse getQuiz(@PathVariable int id) {
        return quizService.busca(id);
    }
}

package org.senai.semana11.quizzes.controllers;

import jakarta.validation.Valid;
import org.senai.semana11.quizzes.dtos.QuizPutRequest;
import org.senai.semana11.quizzes.dtos.QuizRequest;
import org.senai.semana11.quizzes.dtos.QuizResponse;
import org.senai.semana11.quizzes.models.Quiz;
import org.senai.semana11.quizzes.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<QuizResponse> getQuiz(@PathVariable @Valid int id) {
        return ResponseEntity.ok(quizService.busca(id));
    }

    @PostMapping
    public void cadastra(@RequestBody @Valid QuizRequest request) {
        quizService.cadastra(request);
    }

    @PutMapping
    public void atualiza(@RequestBody QuizPutRequest request) {
        quizService.atualiza(request);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable int id) {
        quizService.excluir(id);
    }
}

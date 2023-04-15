package org.senai.semana11.quizzes.controllers;

import org.senai.semana11.quizzes.dtos.PerguntaGetRequest;
import org.senai.semana11.quizzes.dtos.PerguntaResponse;
import org.senai.semana11.quizzes.dtos.QuizResponse;
import org.senai.semana11.quizzes.dtos.RespostaResponse;
import org.senai.semana11.quizzes.services.PerguntaService;
import org.senai.semana11.quizzes.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pergunta")
public class PerguntaController {
    @Autowired
    private PerguntaService perguntaService;

    @GetMapping("/{id}")
    public PerguntaResponse getPergunta(@PathVariable int id) {
        return perguntaService.busca(id);
    }

    @GetMapping
    public List<PerguntaResponse> busca(PerguntaGetRequest params) {
        return perguntaService.busca(params);
    }

}

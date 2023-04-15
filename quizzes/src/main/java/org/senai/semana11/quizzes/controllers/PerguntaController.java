package org.senai.semana11.quizzes.controllers;

import org.senai.semana11.quizzes.dtos.*;
import org.senai.semana11.quizzes.services.PerguntaService;
import org.senai.semana11.quizzes.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public void cadastra(@RequestBody PerguntaRequest request) {
        perguntaService.cadastra(request);
    }

    @PutMapping
    public void atualiza(@RequestBody PerguntaPutRequest request) {
        perguntaService.atualiza(request);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable int id) {
        perguntaService.excluir(id);
    }
}

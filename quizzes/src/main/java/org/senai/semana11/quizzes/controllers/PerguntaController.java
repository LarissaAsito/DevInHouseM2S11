package org.senai.semana11.quizzes.controllers;

import jakarta.validation.Valid;
import org.senai.semana11.quizzes.dtos.*;
import org.senai.semana11.quizzes.models.Pergunta;
import org.senai.semana11.quizzes.services.PerguntaService;
import org.senai.semana11.quizzes.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
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
    public ResponseEntity<Pergunta> cadastra(@RequestBody @Valid PerguntaRequest request, UriComponentsBuilder uriBuilder) {
        Pergunta pergunta = perguntaService.cadastra(request);
        URI uri = uriBuilder.path("/produtos/{id}").buildAndExpand(pergunta.getId()).toUri();
        return ResponseEntity.created(uri).body(pergunta);
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

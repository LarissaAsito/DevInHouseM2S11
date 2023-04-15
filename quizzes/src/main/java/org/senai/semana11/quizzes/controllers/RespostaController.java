package org.senai.semana11.quizzes.controllers;

import org.senai.semana11.quizzes.dtos.*;
import org.senai.semana11.quizzes.services.PerguntaService;
import org.senai.semana11.quizzes.services.RespostaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/resposta")
public class RespostaController {
    @Autowired
    private RespostaService respostaService;

    @GetMapping("/{id}")
    public RespostaResponse getResposta(@PathVariable int id) {
        return respostaService.busca(id);
    }

    @GetMapping
    public List<RespostaResponse> busca(RespostaGetRequest params) {
        return respostaService.busca(params);
    }

    @PostMapping
    public void cadastra(@RequestBody RespostaRequest request) {
        respostaService.cadastra(request);
    }
}

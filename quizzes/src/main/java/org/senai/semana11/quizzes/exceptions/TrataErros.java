package org.senai.semana11.quizzes.exceptions;

import jakarta.persistence.EntityNotFoundException;
import org.senai.semana11.quizzes.dtos.ErroValidacaoDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class TrataErros {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Void> trataErro404() {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ErroValidacaoDTO>> trataErro400(MethodArgumentNotValidException ex) {
        List<FieldError> erros = ex.getFieldErrors();

        return ResponseEntity.badRequest().body(
                erros.stream().map(ErroValidacaoDTO::new).collect(Collectors.toList()));
    }
}

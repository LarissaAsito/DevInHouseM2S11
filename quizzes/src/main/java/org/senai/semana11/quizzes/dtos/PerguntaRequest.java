package org.senai.semana11.quizzes.dtos;

import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import org.senai.semana11.quizzes.models.Quiz;

public class PerguntaRequest {
    @NotBlank
    private String titulo;
    private String texto;

    private Integer quizId;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Integer getQuizId() {
        return quizId;
    }

    public void setQuizId(Integer quizId) {
        this.quizId = quizId;
    }
}

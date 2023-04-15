package org.senai.semana11.quizzes.dtos;

import jakarta.persistence.ManyToOne;
import org.senai.semana11.quizzes.models.Quiz;

public class PerguntaPutRequest {
    private int id;
    private String titulo;
    private String texto;
    private Integer quizId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

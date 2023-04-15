package org.senai.semana11.quizzes.dtos;

import jakarta.persistence.ManyToOne;
import org.senai.semana11.quizzes.models.Pergunta;

public class RespostaPutRequest {
    private int id;
    private String texto;
    private Integer perguntaId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Integer getPerguntaId() {
        return perguntaId;
    }

    public void setPerguntaId(Integer perguntaId) {
        this.perguntaId = perguntaId;
    }
}

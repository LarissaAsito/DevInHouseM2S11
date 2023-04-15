package org.senai.semana11.quizzes.dtos;

import jakarta.persistence.ManyToOne;
import org.senai.semana11.quizzes.models.Pergunta;

public class RespostaRequest {
    private String texto;
    private Integer perguntaId;

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

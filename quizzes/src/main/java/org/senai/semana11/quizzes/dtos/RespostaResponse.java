package org.senai.semana11.quizzes.dtos;

import jakarta.persistence.ManyToOne;
import org.senai.semana11.quizzes.models.Pergunta;

public class RespostaResponse {
    private String texto;
    private Pergunta pergunta;

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Pergunta getPergunta() {
        return pergunta;
    }

    public void setPergunta(Pergunta pergunta) {
        this.pergunta = pergunta;
    }
}

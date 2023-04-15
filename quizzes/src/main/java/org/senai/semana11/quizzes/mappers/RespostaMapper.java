package org.senai.semana11.quizzes.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.senai.semana11.quizzes.dtos.PerguntaResponse;
import org.senai.semana11.quizzes.dtos.RespostaResponse;
import org.senai.semana11.quizzes.models.Pergunta;
import org.senai.semana11.quizzes.models.Resposta;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RespostaMapper {
    List<RespostaResponse> map(List<Resposta> source);
    RespostaResponse map(Resposta source);
}

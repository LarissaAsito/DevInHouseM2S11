package org.senai.semana11.quizzes.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.senai.semana11.quizzes.dtos.PerguntaRequest;
import org.senai.semana11.quizzes.dtos.PerguntaResponse;
import org.senai.semana11.quizzes.dtos.QuizResponse;
import org.senai.semana11.quizzes.models.Pergunta;
import org.senai.semana11.quizzes.models.Quiz;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PerguntaMapper {

    List<PerguntaResponse> map(List<Pergunta> source);
    PerguntaResponse map(Pergunta source);

    @Mapping(target = "quiz.id", source = "quizId")
    Pergunta map(PerguntaRequest source);
}

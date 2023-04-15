package org.senai.semana11.quizzes.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.senai.semana11.quizzes.dtos.QuizPutRequest;
import org.senai.semana11.quizzes.dtos.QuizRequest;
import org.senai.semana11.quizzes.dtos.QuizResponse;
import org.senai.semana11.quizzes.models.Quiz;

import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface QuizMapper {


    List<QuizResponse> map(List<Quiz> source);

    QuizResponse map(Quiz source);

    Quiz map(QuizRequest source);

    Quiz map(QuizPutRequest source);
}

package com.melolingo.app.services;

import com.melolingo.app.dto.ExerciseDto;
import com.melolingo.app.models.Exercise;

import java.util.List;

public interface ExerciseService {
    Exercise createExercise(ExerciseDto exerciseDto);
    Exercise updateExercise(Long exerciseId, ExerciseDto exerciseDto);
    boolean deleteExercise(Long exerciseId);
    List<ExerciseDto> getExercisesByLanguage(String language);
}
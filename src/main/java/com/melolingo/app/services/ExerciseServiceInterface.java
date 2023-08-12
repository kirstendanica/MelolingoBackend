package com.melolingo.app.services;

import com.melolingo.app.dto.ExerciseDto;
import com.melolingo.app.models.Exercise;

public interface ExerciseServiceInterface {
    Exercise createExercise(ExerciseDto exerciseDto);
    Exercise updateExercise(Long exerciseId, ExerciseDto exerciseDto);
    boolean deleteExercise(Long exerciseId);
}

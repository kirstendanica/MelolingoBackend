package com.melolingo.app.services;

import com.melolingo.app.dto.ExerciseDto;
import com.melolingo.app.models.Exercise;

public interface ExerciseService {
    Exercise createExercise(ExerciseDto exerciseDto);
}


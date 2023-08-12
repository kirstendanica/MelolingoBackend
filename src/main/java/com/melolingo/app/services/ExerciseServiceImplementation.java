package com.melolingo.app.services;

import com.melolingo.app.dto.ExerciseDto;
import com.melolingo.app.models.Exercise;
import com.melolingo.app.repo.ExerciseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExerciseServiceImplementation implements ExerciseService {
    private final ExerciseRepo exerciseRepo;
    @Autowired
    public ExerciseServiceImplementation(ExerciseRepo exerciseRepo) {
        this.exerciseRepo = exerciseRepo;
    }
    @Override
    public Exercise createExercise(ExerciseDto exerciseDto) {
        Exercise exercise = new Exercise();
        exercise.setQuestion(exerciseDto.getQuestion());
        exercise.setOptions(exerciseDto.getOptions());
        exercise.setCorrectAns(exerciseDto.getCorrectAns());

        return exerciseRepo.save(exercise);
    }
}

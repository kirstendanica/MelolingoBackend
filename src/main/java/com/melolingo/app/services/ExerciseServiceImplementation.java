package com.melolingo.app.services;

import com.melolingo.app.dto.ExerciseDto;
import com.melolingo.app.models.Exercise;
import com.melolingo.app.repo.ExerciseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

import java.util.List;

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

    @Override
    public Exercise updateExercise(Long exerciseId, ExerciseDto exerciseDto) {
        Exercise exercise = exerciseRepo.findById(exerciseId).orElse(null);
        if (exercise != null) {
            exercise.setQuestion(exerciseDto.getQuestion());
            exercise.setOptions(exerciseDto.getOptions());
            exercise.setCorrectAns(exerciseDto.getCorrectAns());
            return exerciseRepo.save(exercise);
        }
        return null;
    }

    @Override
    public boolean deleteExercise(Long exerciseId) {
        Exercise exercise = exerciseRepo.findById(exerciseId).orElse(null);
        if (exercise != null) {
            exerciseRepo.delete(exercise);
            return true;
        }
        return false;
    }
    @Override
    public List < ExerciseDto > getExercisesByLanguage(String language) {
        List < Exercise > exercises = exerciseRepo.findByLanguage(language);
        List < ExerciseDto > exerciseDtos = convertToExerciseDtos(exercises);
        return exerciseDtos;
    }

    private List < ExerciseDto > convertToExerciseDtos(List < Exercise > exercises) {
        List < ExerciseDto > exerciseDtos = new ArrayList < > ();
        for (Exercise exercise: exercises) {
            ExerciseDto exerciseDto = new ExerciseDto();
            exerciseDto.setQuestion(exercise.getQuestion());
            exerciseDto.setOptions(exercise.getOptions());
            exerciseDto.setCorrectAns(exercise.getCorrectAns());
            exerciseDtos.add(exerciseDto);
        }
        return exerciseDtos;
    }
}
package com.melolingo.app.controller;

import com.melolingo.app.dto.ExerciseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RestController
@RequestMapping("/api/exercises")
public class ExerciseController {
    private final ExerciseService exerciseService;
    @Autowired
    public ExerciseController(ExerciseService exerciseService) {
        this.exerciseService = exerciseService;
    }
    @GetMapping("/language/{language}")
    public List<ExerciseDto> getExercisesByLanguage(@PathVariable String language) {
        return exerciseService.getExercisesByLanguage(language);
    }
}


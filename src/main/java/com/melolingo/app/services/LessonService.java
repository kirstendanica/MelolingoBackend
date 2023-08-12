package com.melolingo.app.services;

import com.melolingo.app.dto.ExerciseDto;
import com.melolingo.app.dto.QuizDto;
import com.melolingo.app.models.Exercise;
import com.melolingo.app.models.Lesson;
import com.melolingo.app.models.Quiz;

import java.util.List;

public interface LessonService {
    Lesson createLesson(Lesson lesson);
    Lesson getLessonById(Long lessonId);
    List<Lesson> getAllLessons();
    Lesson updateLesson(Long lessonId, Lesson lesson);
    boolean deleteLesson(Long lessonId);
    Lesson addExerciseToLesson(Long lessonId, ExerciseDto exerciseDto);
    Lesson addQuizToLesson(Long lessonId, QuizDto quizDto);
    Lesson updateExercise(Long lessonId, Long exerciseId, ExerciseDto exerciseDto);
    Lesson updateQuiz(Long lessonId, Long quizId, QuizDto quizDto);
    Lesson deleteExerciseFromLesson(Long lessonId, Long exerciseId);
    Lesson deleteQuizFromLesson(Long lessonId, Long quizId);
}

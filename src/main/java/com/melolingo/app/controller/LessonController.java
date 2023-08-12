package com.melolingo.app.controller;

import com.melolingo.app.dto.QuizDto;
import com.melolingo.app.dto.ExerciseDto;
import com.melolingo.app.models.Lesson;
import com.melolingo.app.services.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lessons")
public class LessonController {
    private final LessonService lessonService;
    @Autowired
    public LessonController(LessonService lessonService) {
        this.lessonService = lessonService;
    }
    @PostMapping
    public ResponseEntity<Lesson> createLesson(@RequestBody Lesson lesson) {
        Lesson createdLesson = lessonService.createLesson(lesson);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdLesson);
    }
    @GetMapping
    public ResponseEntity<List<Lesson>> getAllLessons() {
        List<Lesson> lessons = lessonService.getAllLessons();
        return ResponseEntity.ok(lessons);
    }
    @GetMapping("/{lessonId}")
    public ResponseEntity<Lesson> getLessonById(@PathVariable Long lessonId) {
        Lesson lesson = lessonService.getLessonById(lessonId);
        if (lesson != null) {
            return ResponseEntity.ok(lesson);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping("/{lessonId}")
    public ResponseEntity<Lesson> updateLesson(@PathVariable Long lessonId, @RequestBody Lesson lesson) {
        Lesson updatedLesson = lessonService.updateLesson(lessonId, lesson);
        if (updatedLesson != null) {
            return ResponseEntity.ok(updatedLesson);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{lessonId}")
    public ResponseEntity<Void> deleteLesson(@PathVariable Long lessonId) {
        boolean deleted = lessonService.deleteLesson(lessonId);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping("/{lessonId}/exercises")
    public ResponseEntity<Lesson> addExerciseToLesson(
            @PathVariable Long lessonId,
            @RequestBody ExerciseDto exerciseDto) {
        Lesson updatedLesson = lessonService.addExerciseToLesson(lessonId, exerciseDto);
        if (updatedLesson != null) {
            return ResponseEntity.ok(updatedLesson);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping("/{lessonId}/quizzes")
    public ResponseEntity<Lesson> addQuizToLesson(
            @PathVariable Long lessonId,
            @RequestBody QuizDto quizDto) {
        Lesson updatedLesson = lessonService.addQuizToLesson(lessonId, quizDto);
        if (updatedLesson != null) {
            return ResponseEntity.ok(updatedLesson);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping("/{lessonId}/exercises/{exerciseId}")
    public ResponseEntity<Lesson> updateExercise(
            @PathVariable Long lessonId,
            @PathVariable Long exerciseId,
            @RequestBody ExerciseDto exerciseDto) {
        Lesson updatedLesson = lessonService.updateExercise(lessonId, exerciseId, exerciseDto);
        if (updatedLesson != null) {
            return ResponseEntity.ok(updatedLesson);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping("/{lessonId}/quizzes/{quizId}")
    public ResponseEntity<Lesson> updateQuiz(
            @PathVariable Long lessonId,
            @PathVariable Long quizId,
            @RequestBody QuizDto quizDto) {
        Lesson updatedLesson = lessonService.updateQuiz(lessonId, quizId, quizDto);
        if (updatedLesson != null) {
            return ResponseEntity.ok(updatedLesson);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{lessonId}/exercises/{exerciseId}")
    public ResponseEntity<Lesson> deleteExerciseFromLesson(
            @PathVariable Long lessonId,
            @PathVariable Long exerciseId) {
        Lesson updatedLesson = lessonService.deleteExerciseFromLesson(lessonId, exerciseId);
        if (updatedLesson != null) {
            return ResponseEntity.ok(updatedLesson);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{lessonId}/quizzes/{quizId}")
    public ResponseEntity<Lesson> deleteQuizFromLesson(
            @PathVariable Long lessonId,
            @PathVariable Long quizId) {
        Lesson updatedLesson = lessonService.deleteQuizFromLesson(lessonId, quizId);
        if (updatedLesson != null) {
            return ResponseEntity.ok(updatedLesson);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

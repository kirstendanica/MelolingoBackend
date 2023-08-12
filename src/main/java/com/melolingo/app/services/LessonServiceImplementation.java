package com.melolingo.app.services;

import com.melolingo.app.dto.ExerciseDto;
import com.melolingo.app.dto.QuizDto;
import com.melolingo.app.models.Exercise;
import com.melolingo.app.models.Lesson;
import com.melolingo.app.models.Quiz;
import com.melolingo.app.repo.LessonRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LessonServiceImplementation implements LessonService {
    private final LessonRepo lessonRepo;

    @Autowired
    public LessonServiceImplementation(LessonRepo lessonRepo) {
        this.lessonRepo = lessonRepo;
    }

    @Override
    public Lesson createLesson(Lesson lesson) {
        return lessonRepo.save(lesson);
    }

    @Override
    public List<Lesson> getAllLessons() {
        return lessonRepo.findAll();
    }

    @Override
    public Lesson getLessonById(Long lessonId) {
        Optional<Lesson> optionalLesson = lessonRepo.findById(lessonId);
        return optionalLesson.orElse(null);
    }

    @Override
    public Lesson updateLesson(Long lessonId, Lesson lesson) {
        if (lessonRepo.existsById(lessonId)) {
            lesson.setId(lessonId);
            return lessonRepo.save(lesson);
        }
        return null;
    }

    @Override
    public boolean deleteLesson(Long lessonId) {
        if (lessonRepo.existsById(lessonId)) {
            lessonRepo.deleteById(lessonId);
            return true;
        }
        return false;
    }

    @Override
    public Lesson addExerciseToLesson(Long lessonId, ExerciseDto exerciseDto) {
        Lesson lesson = getLessonById(lessonId);
        if (lesson == null) {
            return null;
        }
        Exercise exercise = new Exercise();
        exercise.setQuestion(exerciseDto.getQuestion());
        exercise.setOptions(exerciseDto.getOptions());
        exercise.setCorrectAns(exerciseDto.getCorrectAns());

        lesson.getExercises().add(exercise);
        return lessonRepo.save(lesson);
    }
    @Override
    public Lesson addQuizToLesson(Long lessonId, QuizDto quizDto) {
        Lesson lesson = getLessonById(lessonId);
        if (lesson == null) {
            return null;
        }

        Quiz quiz = new Quiz();

        lesson.getQuizzes().add(quiz);
        return lessonRepo.save(lesson);
    }
    @Override
    public Lesson updateExercise(Long lessonId, Long exerciseId, ExerciseDto exerciseDto) {
        Lesson lesson = getLessonById(lessonId);
        if (lesson == null) {
            return null;
        }

        Exercise exerciseToUpdate = lesson.getExercises().stream()
                .filter(exercise -> exercise.getId().equals(exerciseId))
                .findFirst()
                .orElse(null);

        if (exerciseToUpdate == null) {
            return null;
        }

        exerciseToUpdate.setQuestion(exerciseDto.getQuestion());
        exerciseToUpdate.setOptions(exerciseDto.getOptions());
        exerciseToUpdate.setCorrectAns(exerciseDto.getCorrectAns());

        return lessonRepo.save(lesson);
    }

    @Override
    public Lesson updateQuiz(Long lessonId, Long quizId, QuizDto quizDto) {
        Lesson lesson = getLessonById(lessonId);
        if (lesson == null) {
            return null;
        }

        Quiz quizToUpdate = lesson.getQuizzes().stream()
                .filter(quiz -> quiz.getId().equals(quizId))
                .findFirst()
                .orElse(null);

        if (quizToUpdate == null) {
            return null;
        }

        quizToUpdate.setQuestion(quizDto.getQuestion());
        quizToUpdate.setOptions(quizDto.getOptions());
        quizToUpdate.setCorrectAns(quizDto.getCorrectOption());

        return lessonRepo.save(lesson);
    }

    @Override
    public Lesson deleteExerciseFromLesson(Long lessonId, Long exerciseId) {
        Lesson lesson = getLessonById(lessonId);
        if (lesson == null) {
            return null;
        }

        lesson.getExercises().removeIf(exercise -> exercise.getId().equals(exerciseId));

        return lessonRepo.save(lesson);
    }

    @Override
    public Lesson deleteQuizFromLesson(Long lessonId, Long quizId) {
        Lesson lesson = getLessonById(lessonId);
        if (lesson == null) {
            return null;
        }

        lesson.getQuizzes().removeIf(quiz -> quiz.getId().equals(quizId));

        return lessonRepo.save(lesson);
    }
}
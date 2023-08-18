package com.melolingo.app.services;

import com.melolingo.app.models.Lesson;
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
}
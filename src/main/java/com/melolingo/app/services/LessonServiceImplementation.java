package com.melolingo.app.services;

import com.melolingo.app.models.Language;
import com.melolingo.app.services.LanguageService;
import com.melolingo.app.models.Lesson;
import com.melolingo.app.repo.LessonRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public abstract class LessonServiceImplementation implements LessonService {
    private final LessonRepo lessonRepo;
    private final LanguageService languageService;

    @Autowired
    public LessonServiceImplementation(LessonRepo lessonRepo, LanguageService languageService) {
        this.lessonRepo = lessonRepo;
        this.languageService = languageService;
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
    public List<Lesson> getLessonsByLanguage(Language language) {
        return lessonRepo.findByLessonLanguage(language);
    }
}






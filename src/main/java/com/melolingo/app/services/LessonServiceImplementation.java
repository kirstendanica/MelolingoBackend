package com.melolingo.app.services;

import com.melolingo.app.models.Language;
import com.melolingo.app.models.Lesson;
import com.melolingo.app.repo.LessonRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LessonServiceImplementation implements LessonService {
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
    public Lesson updateLesson(Long lessonId, Lesson newLessonDetails) {
        if (lessonRepo.existsById(lessonId)) {
            newLessonDetails.setId(lessonId);
            return lessonRepo.save(newLessonDetails);
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
    public List<Lesson> getLessonsByLanguageCode(String languageCode) {
        Language language = languageService.findLanguageByCode(languageCode);
        if (language != null) {
            return lessonRepo.findByLessonLanguage(language);
        } else {
            throw new IllegalArgumentException("No such language: " + languageCode);
        }
    }
}
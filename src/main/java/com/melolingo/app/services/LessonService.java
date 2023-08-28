package com.melolingo.app.services;

import com.melolingo.app.models.Language;
import com.melolingo.app.models.Lesson;
import com.melolingo.app.controller.LessonController;

import java.util.List;

public interface LessonService {
    Lesson createLesson(Lesson lesson);
    Lesson getLessonById(Long lessonId);
    List<Lesson> getAllLessons();
    Lesson updateLesson(Long lessonId, Lesson lesson);
    boolean deleteLesson(Long lessonId);

    List<Lesson> getLessonsByLanguage(String language);

    List<Lesson> getLessonsByLanguage(Language language);
}
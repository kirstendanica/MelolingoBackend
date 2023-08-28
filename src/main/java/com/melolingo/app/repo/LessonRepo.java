package com.melolingo.app.repo;

import com.melolingo.app.models.Language;
import com.melolingo.app.models.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LessonRepo extends JpaRepository<Lesson, Long> {
    List<Lesson> findByLessonLanguage(Language language);
}
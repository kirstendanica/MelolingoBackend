package com.melolingo.app.repo;

import com.melolingo.app.models.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonRepo extends JpaRepository<Lesson, Long> {
}
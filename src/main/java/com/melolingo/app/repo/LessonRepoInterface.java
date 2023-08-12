package com.melolingo.app.repo;

import com.melolingo.app.models.Lesson;
import com.melolingo.app.models.Language;
import com.melolingo.app.models.Song;
import com.melolingo.app.models.Artist;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LessonRepoInterface extends JpaRepository<Lesson, Long> {
    List<Lesson> findByLessonLanguage(Language language);
    List<Lesson> findBySong(Song song);
    List<Lesson> findByArtist(Artist artist);
}
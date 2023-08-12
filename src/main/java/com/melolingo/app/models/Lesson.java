package com.melolingo.app.models;

import com.melolingo.app.models.Artist;
import com.melolingo.app.models.Song;
import jakarta.persistence.*;
import java.util.List;
import java.util.ArrayList;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "lesson")
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private Long songId;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getSongId() {
        return songId;
    }
    public void setSongId(Long songId) {
        this.songId = songId;
    }
    @OneToMany(mappedBy = "lesson", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Exercise> exercises = new ArrayList<>();

    @OneToMany(mappedBy = "lesson", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Quiz> quizzes = new ArrayList<>();
    public List<Exercise> getExercises() {
        return exercises;
    }

    public void setExercises(List<Exercise> exercises) {
        this.exercises = exercises;
    }

    public List<Quiz> getQuizzes() {
        return quizzes;
    }

    public void setQuizzes(List<Quiz> quizzes) {
        this.quizzes = quizzes;
    }

    @ManyToOne
    @JoinColumn(name = "language_id")
    private Language lessonLanguage;

    @ManyToOne
    @JoinColumn(name = "artist_id")
    private Artist lessonArtist;
}


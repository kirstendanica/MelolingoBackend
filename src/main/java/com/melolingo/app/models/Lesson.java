package com.melolingo.app.models;

import jakarta.persistence.*;

@Entity
@Table(name="lesson")
public class Lesson{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "artist_id")
    private Artist artist;

    @ManyToOne
    @JoinColumn(name = "song_id")
    private Song song;
    private String title;
    private String description;

    @Transient
    private Long songId;

    @ManyToOne
    private Language lessonLanguage;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Language getLessonLanguage() {
        return lessonLanguage;
    }

    public void setLessonLanguage(Language lessonLanguage) {
        this.lessonLanguage = lessonLanguage;
    }
}
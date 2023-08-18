package com.melolingo.app.models;

import jakarta.persistence.*;

@Entity
@Table(name="vocab")
public class Vocab{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private Long lessonId;
    private String word;
    private String translation;
    private String grammarPoint;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getLessonId() {
        return lessonId;
    }

    public void setLessonId(Long lessonId) {
        this.lessonId = lessonId;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    public String getGrammarPoint() {
        return grammarPoint;
    }

    public void setGrammarPoint(String grammarPoint) {
        this.grammarPoint = grammarPoint;
    }
}
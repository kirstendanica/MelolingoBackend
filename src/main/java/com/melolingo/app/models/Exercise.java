package com.melolingo.app.models;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "exercise")
public class Exercise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lesson_id")
    private Lesson lesson;

    private String question;
    private String options;
    private String correctAns;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Lesson getLesson() {
        return lesson;
    }
    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }
    public String getQuestion() {
        return question;
    }
    public void setQuestion(String question) {
        this.question = question;
    }
    public String getOptions() {
        return options;
    }
    public void setOptions(String options) {
        this.options = options;
    }
    public String getCorrectAns() {
        return correctAns;
    }
    public void setCorrectAns(String correctAns) {
        this.correctAns = correctAns;
    }
}

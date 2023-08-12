package com.melolingo.app.dto;

import java.util.List;

public class QuizDto {
    private String question;
    private List<String> options;
    private String correctOption;

    // Getters & setters
    public String getQuestion() {
        return question;
    }
    public void setQuestion(String question) {
        this.question = question;
    }
    public List<String> getOptions() {
        return options;
    }
    public void setOptions(List<String> options) {
        this.options = options;
    }
    public String getCorrectOption() {
        return correctOption;
    }
    public void setCorrectOption(String correctOption) {
        this.correctOption = correctOption;
    }
}
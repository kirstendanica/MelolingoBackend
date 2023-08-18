package com.melolingo.app.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import com.melolingo.app.models.Lesson;

@Entity
@Table(name = "language")
public class Language {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Language name is required")
    @Column(name = "name", nullable = false, unique = true)
    private String name;

    // Constructors, getters, and setters

    public Language() {
    }

    public Language(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

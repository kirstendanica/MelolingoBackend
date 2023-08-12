package com.melolingo.app.models;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
@Entity
@Table(name = "vocab")
public class Vocab {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long lessonId; // Link to lesson
    private String word;
    private String translation;
    private String grammarPoint;
}
package com.melolingo.app.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
@Entity
public class Language {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Language required")
    private String name;
    public Language() {
    }
    public Language(String name)
    {

        this.name = name;
    }
    public Long getId() {return id;
    }
    public void setId(Long id)
    {

        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
}
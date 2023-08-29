package com.melolingo.app.repo;

import com.melolingo.app.models.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LanguageRepo extends JpaRepository<Language, Long> {
    Language findByCode(String code);
}
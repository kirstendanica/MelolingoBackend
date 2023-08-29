package com.melolingo.app.services;

import com.melolingo.app.models.Language;
import com.melolingo.app.repo.LanguageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LanguageServiceImplementation implements LanguageService {
    private final LanguageRepo languageRepo;

    @Autowired
    public LanguageServiceImplementation(LanguageRepo languageRepo) {

        this.languageRepo = languageRepo;
    }

    @Override
    public Language findLanguageByCode(String languageCode) {
        return languageRepo.findByCode(languageCode);
        // TBA findByCode() method in repository
    }
}
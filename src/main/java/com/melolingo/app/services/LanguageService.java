package com.melolingo.app.services;

import com.melolingo.app.models.Language;

public interface LanguageService {
    Language findLanguageByCode(String languageCode);
}
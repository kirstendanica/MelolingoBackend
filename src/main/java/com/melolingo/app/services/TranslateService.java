package com.melolingo.app.services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import java.util.HashMap;
import java.util.Map;

@Service
public class TranslateService {

    public String translateText(String text, String sourceLanguage, String targetLanguage) {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        String url = "https://libretranslate.com/translate";
        String queryParams = String.format("?q=%s&source=%s&target=%s", text, sourceLanguage, targetLanguage);

        Map<String, String> response = restTemplate.getForObject(url + queryParams, Map.class);

        if (response != null) {
            return response.get("translatedText");
        }

        return null;
    }
}

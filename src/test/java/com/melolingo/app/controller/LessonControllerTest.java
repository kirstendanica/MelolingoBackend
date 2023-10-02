package com.melolingo.app.controller;

import static org.mockito.Mockito.*;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

import com.melolingo.app.controller.LessonController;
import com.melolingo.app.models.Language;
import com.melolingo.app.models.Lesson;
import com.melolingo.app.services.LessonService;

@RunWith(MockitoJUnitRunner.class)
public class LessonControllerTest {

    @Mock
    private LessonService lessonService;

    @InjectMocks
    private LessonController lessonController;

    private List<Lesson> mockLessons;

    @Before
    public void setUp() {
        mockLessons = new ArrayList<>();
        mockLessons.add(new Lesson(/* Initialize with mock data */));
        // Add more mock lessons as needed
    }

    @Test
    public void testGetLessonsByLanguage_ValidLanguage() {
        // Mock the behavior of lessonService method
        when(lessonService.getLessonsByLanguageCode(anyString())).thenReturn(mockLessons);

        // Call the controller method
        ResponseEntity<List<Lesson>> response = lessonController.getLessonsByLanguage(Language.LanguageEnum.ENGLISH.name());

        // Assert the response status code
        assertEquals(HttpStatus.OK, response.getStatusCode());

        // Assert the response body
        assertEquals(mockLessons, response.getBody());
    }
}
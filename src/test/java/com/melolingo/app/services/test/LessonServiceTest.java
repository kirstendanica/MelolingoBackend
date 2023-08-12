package com.melolingo.app.services.test;

import com.melolingo.app.dto.ExerciseDto;
import com.melolingo.app.models.Lesson;
import com.melolingo.app.repo.LessonRepo;
import com.melolingo.app.services.LessonServiceImplementation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

public class LessonServiceTest {

    @Mock
    private LessonRepo lessonRepo;

    @InjectMocks
    private LessonServiceImplementation lessonService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddExerciseToLesson() {
        // Configure mock data
        ExerciseDto exerciseDto = new ExerciseDto();
        exerciseDto.setQuestion("Sample question");
        exerciseDto.setOptions(String.valueOf(Arrays.asList("Option 1", "Option 2", "Option 3")));
        exerciseDto.setCorrectAns("Option 1");

        Lesson lesson = new Lesson();
        lesson.setId(1L); // Set a lesson ID
        when(lessonRepo.findById(1L)).thenReturn(Optional.of(lesson));

        // Call method
        Lesson updatedLesson = lessonService.addExerciseToLesson(1L, exerciseDto);

        // Assertions
        assertNotNull(updatedLesson);
        assertEquals(1, updatedLesson.getExercises().size());
        assertEquals("Sample question", updatedLesson.getExercises().get(0).getQuestion());
    }

    @Test
    public void testAddExerciseToNonExistentLesson() {
        // Configure mock data
        ExerciseDto exerciseDto = new ExerciseDto();
        exerciseDto.setQuestion("Sample question");
        exerciseDto.setOptions(String.valueOf(Arrays.asList("Option 1", "Option 2", "Option 3")));
        exerciseDto.setCorrectAns("Option 1");

        when(lessonRepo.findById(any())).thenReturn(Optional.empty()); // Simulate lesson not found

        // Call method
        Lesson updatedLesson = lessonService.addExerciseToLesson(1L, exerciseDto);

        // Assertions
        assertNull(updatedLesson); // Should return 'null' for non-existent lesson
    }
}
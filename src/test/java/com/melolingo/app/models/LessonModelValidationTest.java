package com.melolingo.app.models;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

import java.util.Set;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LessonModelValidationTest {

    @Test
    public void testLessonModelValidation() {
        // Create a validator factory
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        // Create a Lesson instance with valid fields
        Lesson lesson = new Lesson();
        lesson.setTitle("Valid Title");
        lesson.setDescription("Valid Description");

        // Set a valid Language or mock a Language object
        Language language = new Language();
        language.setCode("en"); //
        lesson.setLessonLanguage(language);

        // Validate the Lesson instance
        Set<ConstraintViolation<Lesson>> violations = validator.validate(lesson);

        // Check if no violations were found
        assertEquals(0, violations.size());
    }
}
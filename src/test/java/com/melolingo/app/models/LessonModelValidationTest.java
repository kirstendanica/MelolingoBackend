package com.melolingo.app.models;

import jakarta.validation.ConstraintViolation;
import org.junit.Test;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class LessonModelValidationTest {

    @Test
    public void testLessonModelValidation() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Lesson lesson = new Lesson();
        lesson.setTitle("Valid Title");
        lesson.setDescription("Valid Description");
        Language language = new Language();
        language.setCode("en");
        lesson.setLessonLanguage(language);

        Set<ConstraintViolation<Lesson>> violations = validator.validate(lesson);

        assertEquals(0, violations.size());
    }
}
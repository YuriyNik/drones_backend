package com.drones.drones_backend.model;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static jakarta.validation.Validation.buildDefaultValidatorFactory;
import static org.junit.jupiter.api.Assertions.*;

class MedicationTest {

    private Validator validator;
    private final Medication medication =
            new Medication("CODE123EDFR","Paracetomol",10);
    @BeforeEach
    public void setup() {
        try (ValidatorFactory factory = buildDefaultValidatorFactory()) {
            validator = factory.getValidator();
        }
    }


    @Test
    public void whenValidMedication_thenNoConstraintViolations() {
        Medication medication = new Medication("CODE123", "MedName-123", 100);
        Set<ConstraintViolation<Medication>> violations = validator.validate(medication);
        assertTrue(violations.isEmpty());
    }
    @Test
    public void whenInvalidCode_thenConstraintViolation() {
        Medication medication = new Medication("invalid-code", "MedName", 100);
        Set<ConstraintViolation<Medication>> violations = validator.validate(medication);
        assertFalse(violations.isEmpty());
        assertEquals("allowed only upper case letters, underscore and numbers",
                violations.iterator().next().getMessage());
    }
    @Test
    public void whenInvalidName_thenConstraintViolation() {
        Medication medication = new Medication("CODE123", "Invalid Name!", 100);
        Set<ConstraintViolation<Medication>> violations = validator.validate(medication);
        assertFalse(violations.isEmpty());
        assertEquals("allowed only letters, numbers, ‘-‘, ‘_’",
                violations.iterator().next().getMessage());
    }

    @Test
    void getCode() {
        assertEquals("CODE123EDFR",medication.getCode());
    }

    @Test
    void getName() {
        assertEquals("Paracetomol",medication.getName());

    }

    @Test
    void getWeight() {
        assertEquals(10,medication.getWeight());

    }

    @Test
    void testToString() {
        assertEquals("Medication{" +
                "code='" + medication.getCode() + '\'' +
                ", name='" + medication.getName() + '\'' +
                ", weight=" + medication.getWeight() +
                '}' , medication.toString());
    }
}
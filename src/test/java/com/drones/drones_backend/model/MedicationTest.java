package com.drones.drones_backend.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MedicationTest {
    private final Medication medication =
            new Medication("CODE123EDFR","Paracetomol",10);

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
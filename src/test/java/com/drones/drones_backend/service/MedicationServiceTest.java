package com.drones.drones_backend.service;

import com.drones.drones_backend.model.Medication;
import com.drones.drones_backend.repository.MedicationRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBeans;

import static org.hamcrest.Matchers.any;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MedicationServiceTest {
    @Mock
    private MedicationRepository medicationRepository;

    @InjectMocks
    private MedicationService medicationService;

//    @Test
    public void testSaveMedication() {
        Medication mockMedication = new Medication("code123", "MedName", 100);
       // when(medicationRepository.save(any(Medication.class))).thenReturn(mockMedication);



        Medication savedMedication = medicationService.saveMedication(mockMedication);
        assertEquals("code123", savedMedication.getCode());
    }

    @Test
    void getMedication() {
    }
}
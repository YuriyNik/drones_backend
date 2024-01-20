package com.drones.drones_backend.service;

import com.drones.drones_backend.model.Medication;
import com.drones.drones_backend.repository.MedicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicationService {

    @Autowired
    private MedicationRepository medicationRepository;

    public Medication saveMedication(Medication medication) {
        return medicationRepository.save(medication);
    }

    public Medication getMedication(String code) {
        return medicationRepository.findById(code).orElse(null);
    }

}

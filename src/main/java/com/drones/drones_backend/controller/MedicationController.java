package com.drones.drones_backend.controller;

import com.drones.drones_backend.model.Medication;
import com.drones.drones_backend.service.MedicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/medications")
public class MedicationController {

    @Autowired
    private MedicationService medicationService;

    @PostMapping("/")
    public ResponseEntity<Medication> createMedication(@RequestBody Medication medication) {
        Medication savedMedication = medicationService.saveMedication(medication);
        return ResponseEntity.ok(savedMedication);
    }

    @GetMapping("/{code}")
    public ResponseEntity<Medication> getMedication(@PathVariable String code) {
        Medication medication = medicationService.getMedication(code);
        if (medication != null) {
            return ResponseEntity.ok(medication);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}


package com.drones.drones_backend.repository;

import com.drones.drones_backend.model.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class RepositoryTest {

    @Autowired
    DroneRepository droneRepository;
    @Autowired
    MedicationRepository medicationRepository;
    @Autowired
    DroneMedicationRepository droneMedicationRepository;

    Drone drone =
            new Drone("SN12345", DroneModel.LIGHTWEIGHT, 500, 100, DroneState.IDLE);
    Medication medication =
            new Medication("CODE123EDFR","Paracetomol",10);


    @Test
    public void testDronSaveAndFind() {
         droneRepository.save(drone);

        Drone found = droneRepository.findById(drone.getSerialNumber()).orElse(null);
        assertNotNull(found);
        System.out.println(found);
        // More assertions based on drone properties
    }
    @Test
    public void testMedicationSaveAndFind() {
        medicationRepository.save(medication);

        Medication found = medicationRepository.findById(medication.getCode()).orElse(null);
        assertNotNull(found);
        System.out.println(found);

        DroneMedication droneMedication = new DroneMedication(drone,medication); // Set properties
        droneMedicationRepository.save(droneMedication);

        DroneMedication foundDM = droneMedicationRepository.findById(droneMedication.getId()).orElse(null);
        assertNotNull(foundDM);
        System.out.println(foundDM);


    }

    @Test
    public void testDroneMedicationSaveAndFind() {

    }

}
package com.drones.drones_backend.repository;

import com.drones.drones_backend.model.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class RepositoryTest {

    @Autowired
    DroneRepository droneRepository;
    @Autowired
    MedicationRepository medicationRepository;
    @Autowired
    DroneMedicationRepository droneMedicationRepository;
    @Autowired
    EventLogRepository eventLogRepository;

    Drone drone =
            new Drone("SN12345", DroneModel.LIGHTWEIGHT, 500, 100, DroneState.IDLE);
    Medication medication =
            new Medication("CODE123EDFR","Paracetomol",10);


    @BeforeAll
    public static void preSeed(){
    }

    @Test
    public void testDroneSaveAndFind() {
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

    @Test
    public void setEventLogRepository(){
        droneRepository.save(drone);
        EventLog eventLog =
                new EventLog(drone, "test", 100);
        eventLogRepository.save(eventLog);
        List<EventLog> found = eventLogRepository.findByDroneSerialNumber(drone.getSerialNumber());
        assertNotNull(found);
        System.out.println(found);


    }

}
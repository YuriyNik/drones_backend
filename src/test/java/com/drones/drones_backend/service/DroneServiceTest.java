package com.drones.drones_backend.service;

import com.drones.drones_backend.model.*;
import com.drones.drones_backend.repository.DroneMedicationRepository;
import com.drones.drones_backend.repository.DroneRepository;
import com.drones.drones_backend.repository.MedicationRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DroneServiceTest {
    @Mock
    private DroneRepository droneRepository;

    @Mock
    private MedicationRepository medicationRepository;
    @Mock
    private DroneMedicationRepository droneMedicationRepository;

    @InjectMocks
    private DroneService droneService;

    @Test
    void registerDrone() {
        Drone drone = new Drone("SN12345_test", DroneModel.LIGHTWEIGHT, 500, 30, DroneState.IDLE);
        when(droneRepository.save(any(Drone.class))).thenReturn(drone);

        Drone result = droneService.registerDrone(drone);
        assertEquals(drone, result);
        verify(droneRepository).save(drone);
    }

    @Test
    void loadMedication() {
        String droneSerialNumber = "SN12345_test";
        Drone drone = new Drone(droneSerialNumber, DroneModel.LIGHTWEIGHT, 500, 30, DroneState.IDLE);
        String medicationCode = "MEDCODE123_test";

        Medication medication = new Medication(medicationCode, "MedName", 300);

        when(droneRepository.findById(droneSerialNumber)).thenReturn(Optional.of(drone));
        when(medicationRepository.findById(medicationCode)).thenReturn(Optional.of(medication));
        when(droneMedicationRepository.findByDroneSerialNumber(droneSerialNumber)).thenReturn(new ArrayList<>()); // No medications loaded initially
        droneService.loadMedication(droneSerialNumber, medicationCode);
        verify(droneMedicationRepository).save(any(DroneMedication.class));
    }

    @Test
    void getLoadedMedications() {
        String droneSerialNumber = "DRONE123";
        List<DroneMedication> loadedMedications = new ArrayList<>(); // Populate with test data
        when(droneMedicationRepository.findByDroneSerialNumber(droneSerialNumber)).thenReturn(loadedMedications);
        List<Medication> result = droneService.getLoadedMedications(droneSerialNumber);

    }

    @Test
    void getAvailableDrones() {
        List<Drone> allDrones = new ArrayList<>(); // Populate with test drones
        when(droneRepository.findAll()).thenReturn(allDrones);

        List<Drone> availableDrones = droneService.getAvailableDrones();
    }

    @Test
    void getDroneBatteryLevel() {
        String droneSerialNumber = "DRONE123";
        Drone drone = new Drone(droneSerialNumber, DroneModel.LIGHTWEIGHT, 500, 30, DroneState.IDLE);
        drone.setBatteryCapacity(50);
        when(droneRepository.findById(droneSerialNumber)).thenReturn(Optional.of(drone));
        int batteryLevel = droneService.getDroneBatteryLevel(droneSerialNumber);
        assertEquals(50, batteryLevel);
    }
}
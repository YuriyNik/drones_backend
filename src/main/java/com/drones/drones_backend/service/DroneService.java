package com.drones.drones_backend.service;

import com.drones.drones_backend.model.Drone;
import com.drones.drones_backend.model.DroneMedication;
import com.drones.drones_backend.model.Medication;
import com.drones.drones_backend.repository.DroneRepository;
import com.drones.drones_backend.repository.DroneMedicationRepository;
import com.drones.drones_backend.repository.MedicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class DroneService {
    @Autowired
    DroneRepository droneRepository;
    @Autowired
    MedicationRepository medicationRepository;
    @Autowired
    DroneMedicationRepository droneMedicationRepository;

    public Drone registerDrone(Drone drone) {
        droneRepository.save(drone);
        return drone;
    }

    public void loadMedication(String droneSerialNumber, String medicationCode) {
        Optional<Drone> drone = droneRepository.findById(droneSerialNumber);
        Optional<Medication> medication = medicationRepository.findById(medicationCode);
        if (drone.isEmpty() || medication.isEmpty()) {
            return;
        }
        Drone currentDrone = drone.get();
        // Check if drone's battery level is below 25%
        if (currentDrone.getBatteryCapacity() < 25) {
            throw new IllegalStateException("Drone battery level too low for loading");
        }
        // Check if the drone can carry the additional weight
        double totalWeight = droneMedicationRepository.findByDroneSerialNumber(droneSerialNumber)
                .stream()
                .mapToDouble(dm -> dm.getMedication().getWeight())
                .sum() + medication.get().getWeight();
        System.out.println("totalWeight="+totalWeight);
        if (totalWeight > currentDrone.getWeightLimit()) {
            throw new IllegalStateException("Drone cannot carry the additional weight");
        }
        DroneMedication droneMedication = new DroneMedication(drone.get(), medication.get());
        droneMedicationRepository.save(droneMedication);
        System.out.println("loadMedication="+droneMedication);
    }

    public List<Medication> getLoadedMedications(String droneSerialNumber) {
        return droneMedicationRepository.findByDroneSerialNumber(droneSerialNumber)
                .stream()
                .map(DroneMedication::getMedication)
                .collect(Collectors.toList());
    }

    public List<Drone> getAvailableDrones() {
        return droneRepository.findAll();
    }

    public int getDroneBatteryLevel(String droneSerialNumber) {
        Optional<Drone> drone = droneRepository.findById(droneSerialNumber);
      return drone.map(Drone::getBatteryCapacity).orElse(-1);
    }

   /* public List<EventLog> getDroneEventHistory(String droneSerialNumber) {
        // Logic to get event history for a drone
    }

    public List<MedicationLoadSummary> getMedicationLoadSummary() {
        // Logic to get summary of loaded medications across all drones
    }
    */

}


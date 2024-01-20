package com.drones.drones_backend.service;

import com.drones.drones_backend.model.Drone;
import com.drones.drones_backend.model.DroneMedication;
import com.drones.drones_backend.model.Medication;
import com.drones.drones_backend.repository.DronRepository;
import com.drones.drones_backend.repository.DroneMedicationRepository;
import com.drones.drones_backend.repository.MedicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class DroneService {
    @Autowired
    DronRepository dronRepository;
    @Autowired
    MedicationRepository medicationRepository;
    @Autowired
    DroneMedicationRepository droneMedicationRepository;

    public Drone registerDrone(Drone drone) {
        dronRepository.save(drone);
        return drone;
    }

    public void loadMedication(String droneSerialNumber, String medicationCode) {
     //   DroneMedication droneMedication = new DroneMedication(droneSerialNumber, medicationCode);
     //   droneMedicationList.add(droneMedication);
    }

    public List<Medication> getLoadedMedications(String droneSerialNumber) {
//        List<DroneMedication> filteredList = droneMedicationRepository.findBy()

        return null;

    }

    public List<Drone> getAvailableDrones() {
        return dronRepository.findAll();
    }

    public int getDroneBatteryLevel(String droneSerialNumber) {
        Optional<Drone> drone = dronRepository.findById(droneSerialNumber);
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

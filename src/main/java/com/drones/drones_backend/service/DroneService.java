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
    public Map<String, Integer> getMedicationCountByDrone() {
        // Fetch all DroneMedication records
        List<DroneMedication> droneMedications = droneMedicationRepository.findAll();

        // Map to keep track of medication count per drone
        Map<String, Integer> medicationCountByDrone = new HashMap<>();

        for (DroneMedication dm : droneMedications) {
            String droneSerial = dm.getDrone().getSerialNumber();
            medicationCountByDrone.put(droneSerial, medicationCountByDrone.getOrDefault(droneSerial, 0) + 1);
        }

        // Return the map ordered by medication count in descending order
        return medicationCountByDrone.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new));
    }
//todo get rid of exceptions - implement errors here and on controller level
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
        if (getTotalLoadedWeight(droneSerialNumber)+ medication.get().getWeight() > currentDrone.getWeightLimit()) {
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
        List<Drone> allDrones = droneRepository.findAll();
        return allDrones.stream()
                .filter(this::isDroneAvailableForLoading)
                .collect(Collectors.toList());
    }
    private double getTotalLoadedWeight(String serialNumber){
        return droneMedicationRepository.findByDroneSerialNumber(serialNumber)
                .stream()
                .mapToDouble(dm -> dm.getMedication().getWeight())
                .sum();
    }
    private boolean isDroneAvailableForLoading(Drone drone) {
        if (drone.getBatteryCapacity() < 25) {
            return false; // Drone battery is below 25%, so it's not available
        }
        return getTotalLoadedWeight(drone.getSerialNumber()) < drone.getWeightLimit();
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


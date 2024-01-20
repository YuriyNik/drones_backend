package com.drones.drones_backend.service;

import com.drones.drones_backend.model.Drone;
import com.drones.drones_backend.model.Medication;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DroneService {

    public Drone registerDrone(Drone drone) {
        // Logic to register a drone
    }

    public void loadMedication(String droneSerialNumber, Medication medication) {
        // Logic to load medication to a drone
    }

    public List<Medication> getLoadedMedications(String droneSerialNumber) {
        // Logic to get loaded medications for a drone
    }

    public List<Drone> getAvailableDrones() {
        // Logic to get available drones
    }

    public int getDroneBatteryLevel(String droneSerialNumber) {
        // Logic to get the battery level of a drone
    }

   /* public List<EventLog> getDroneEventHistory(String droneSerialNumber) {
        // Logic to get event history for a drone
    }

    public List<MedicationLoadSummary> getMedicationLoadSummary() {
        // Logic to get summary of loaded medications across all drones
    }
    */

}


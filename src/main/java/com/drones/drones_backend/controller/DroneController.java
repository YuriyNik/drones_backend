package com.drones.drones_backend.controller;

import com.drones.drones_backend.model.Drone;
import com.drones.drones_backend.model.Medication;
import com.drones.drones_backend.service.DroneService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@RestController
@RequestMapping("/api/drones")
public class DroneController {

    @Autowired
    private DroneService droneService;

    @PostMapping("/register")
    public Drone registerDrone(@RequestBody Drone drone) {
        return droneService.registerDrone(drone);
    }

    @PostMapping("/{serialNumber}/loadMedication")
    public void loadMedication(@PathVariable String serialNumber, @RequestBody Medication medication) {
        droneService.loadMedication(serialNumber, medication);
    }

    @GetMapping("/{serialNumber}/loadedMedications")
    public List<Medication> getLoadedMedications(@PathVariable String serialNumber) {
        return droneService.getLoadedMedications(serialNumber);
    }

    @GetMapping("/available")
    public List<Drone> getAvailableDrones() {
        return droneService.getAvailableDrones();
    }

    @GetMapping("/{serialNumber}/batteryLevel")
    public int getBatteryLevel(@PathVariable String serialNumber) {
        return droneService.getDroneBatteryLevel(serialNumber);
    }
/*
    @GetMapping("/{serialNumber}/eventHistory")
    public List<EventLog> getEventHistory(@PathVariable String serialNumber) {
        return droneService.getDroneEventHistory(serialNumber);
    }

    @GetMapping("/medicationLoadSummary")
    public List<MedicationLoadSummary> getMedicationLoadSummary() {
        return droneService.getMedicationLoadSummary();
    }
 */

}

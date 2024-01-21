package com.drones.drones_backend.configuration;

import com.drones.drones_backend.model.Drone;
import com.drones.drones_backend.model.EventLog;
import com.drones.drones_backend.repository.DroneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DroneBatteryCheckScheduler {

    @Autowired
    private DroneRepository droneRepository;
//    @Autowired
//  private EventLogRepository eventLogRepository; // Assuming you have an EventLog entity to log events

    @Scheduled(fixedRate = 6000) // Runs every 6000 milliseconds (6 secs)
    public void checkDroneBatteryLevels() {
        List<Drone> drones = droneRepository.findAll();
        for (Drone drone : drones) {
            int batteryLevel = drone.getBatteryCapacity();
            // Log the battery level in the event log
            EventLog log = new EventLog(drone.getSerialNumber(), "Battery check", batteryLevel);
   //         eventLogRepository.save(log);
            System.out.println(log);
        }
    }
}

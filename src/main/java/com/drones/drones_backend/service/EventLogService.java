package com.drones.drones_backend.service;

import com.drones.drones_backend.model.EventLog;
import com.drones.drones_backend.repository.DroneRepository;
import com.drones.drones_backend.repository.EventLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventLogService {
    @Autowired
    EventLogRepository eventLogRepository;
    public List<EventLog> getAllEventsForDrone(String droneSerialNumber){
        return eventLogRepository.findByDroneSerialNumber(droneSerialNumber);
    }

}

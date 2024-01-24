package com.drones.drones_backend.controller;

import com.drones.drones_backend.model.EventLog;
import com.drones.drones_backend.service.EventLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/eventlog")
public class EventLogController {
    @Autowired
    EventLogService eventLogService;
    @GetMapping("/{serialNumber}")
    public List<EventLog> getEventLogsforDrone(@PathVariable String serialNumber){
        List<EventLog> results = eventLogService.getAllEventsForDrone(serialNumber);
        System.out.println(results);
        return results;
    }
}

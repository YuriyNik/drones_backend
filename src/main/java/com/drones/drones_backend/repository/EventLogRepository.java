package com.drones.drones_backend.repository;
import com.drones.drones_backend.model.EventLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventLogRepository extends JpaRepository<EventLog, String> {
    List<EventLog> findByDroneSerialNumber(String serialNumber);
}

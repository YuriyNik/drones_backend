package com.drones.drones_backend.repository;

import com.drones.drones_backend.model.DroneMedication;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DroneMedicationRepository extends JpaRepository<DroneMedication,Long> {
    List<DroneMedication> findByDroneSerialNumber(String serialNumber);

}

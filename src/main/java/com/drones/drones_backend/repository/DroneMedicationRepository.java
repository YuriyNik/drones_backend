package com.drones.drones_backend.repository;

import com.drones.drones_backend.model.DroneMedication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DroneMedicationRepository extends JpaRepository<DroneMedication,Long> {
}

package com.drones.drones_backend.repository;

import com.drones.drones_backend.model.Medication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicationRepository extends JpaRepository<Medication,String> {
}

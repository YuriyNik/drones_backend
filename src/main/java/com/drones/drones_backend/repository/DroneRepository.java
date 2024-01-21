package com.drones.drones_backend.repository;

import com.drones.drones_backend.model.Drone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DroneRepository extends JpaRepository<Drone, String> {
}

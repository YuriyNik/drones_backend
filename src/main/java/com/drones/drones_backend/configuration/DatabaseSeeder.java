package com.drones.drones_backend.configuration;

import com.drones.drones_backend.model.Drone;
import com.drones.drones_backend.model.DroneModel;
import com.drones.drones_backend.model.DroneState;
import com.drones.drones_backend.model.Medication;
import com.drones.drones_backend.repository.DronRepository;
import com.drones.drones_backend.repository.MedicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class DatabaseSeeder {

    @Autowired
    private DronRepository dronRepository;
    @Autowired
    private MedicationRepository medicationRepository;

    @EventListener
    public void seed(ContextRefreshedEvent event) {
        seedDronesTable();
        seedMedicationsTable();
    }

    private void seedDronesTable() {
        if (dronRepository.count() == 0) {
            for (int i = 0; i <10 ; i++) {
                Drone drone = new Drone("SN12345"+i, DroneModel.LIGHTWEIGHT, 500, 20+i, DroneState.IDLE);
                dronRepository.save(drone);
            }
        }
    }

    private void seedMedicationsTable() {
        if (medicationRepository.count() == 0) {
            for (int i = 0; i < 10; i++) {
                Medication medication = new Medication("MEDCODE123"+i, "MedName"+i, 200);
                medicationRepository.save(medication);
            }
        }
    }
}


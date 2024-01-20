package com.drones.drones_backend.model;


import jakarta.persistence.*;

@Entity
@Table(name = "drone_medications")
public class DroneMedication {

    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "drone_id", referencedColumnName = "serial_number")
    private Drone drone;

    @ManyToOne
    @JoinColumn(name = "medication_id", referencedColumnName = "code")
    private Medication medication;

    public DroneMedication(Long id,Drone drone, Medication medication) {
        this.id = id;
        this.drone = drone;
        this.medication = medication;
    }

    public DroneMedication() {

    }
}

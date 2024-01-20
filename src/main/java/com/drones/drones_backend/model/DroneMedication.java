package com.drones.drones_backend.model;


import jakarta.persistence.*;

@Entity
@Table(name = "drone_medications")
public class DroneMedication {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "drone_serial_number", referencedColumnName = "serial_number")
    private Drone drone;

    @ManyToOne
    @JoinColumn(name = "medication_code", referencedColumnName = "code")
    private Medication medication;

    public DroneMedication(Long id,Drone drone, Medication medication) {
        this.id = id;
        this.drone = drone;
        this.medication = medication;
    }
    public DroneMedication(Drone drone, Medication medication) {
        this.drone = drone;
        this.medication = medication;
    }

    public DroneMedication() {

    }

    public Long getId() {
        return id;
    }

    public Drone getDroneSerialNumber() {
        return drone;
    }

    public Medication getMedicationCode() {
        return medication;
    }

    @Override
    public String toString() {
        return "DroneMedication{" +
                "id=" + id +
                ", drone=" + drone +
                ", medication=" + medication +
                '}';
    }
}

package com.drones.drones_backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;

@Entity
@Table(name = "drones")
public class Drone {
    @Id
    @Column(name = "serial_number", length = 100, nullable = false)
    private String serialNumber;

    @Column(name = "model", nullable = false)
    private DroneModel model;

    @Column(name = "weightLimit", nullable = false)
    @Max(500)
    private int weightLimit;

    @Column(name = "batteryCapacity", nullable = false)
    @Max(100)
    private int batteryCapacity;

    @Column(name = "state", nullable = false)
    private DroneState state;
    public Drone(String serialNumber, DroneModel model, int weightLimit, int batteryCapacity, DroneState state) {
        this.serialNumber = serialNumber;
        this.model = model;
        this.weightLimit = weightLimit;
        this.batteryCapacity = batteryCapacity;
        this.state = state;
    }

    public Drone() {

    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public DroneModel getModel() {
        return model;
    }

    public void setBatteryCapacity(int batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public int getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setState(DroneState state) {
        this.state = state;
    }

    public DroneState getState() {
        return state;
    }

    public int getWeightLimit() {
        return weightLimit;
    }

    @Override
    public String toString() {
        return "Drone{" +
                "serialNumber='" + serialNumber + '\'' +
                ", model=" + model +
                ", weightLimit=" + weightLimit +
                ", batteryCapacity=" + batteryCapacity +
                ", state=" + state +
                '}';
    }
}


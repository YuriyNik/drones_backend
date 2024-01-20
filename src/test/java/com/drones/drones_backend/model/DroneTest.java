package com.drones.drones_backend.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DroneTest {

    private final Drone drone =
            new Drone("SN12345", DroneModel.LIGHTWEIGHT, 500, 100, DroneState.IDLE);

    @Test
    void getSerialNumber() {
        assertEquals("SN12345", drone.getSerialNumber());

    }

    @Test
    void getModel() {
        assertEquals(DroneModel.LIGHTWEIGHT, drone.getModel());
    }

    @Test
    void setBatteryCapacity() {
        drone.setBatteryCapacity(300);
        assertEquals(300, drone.getBatteryCapacity());
    }

    @Test
    void getBatteryCapacity() {
        drone.setBatteryCapacity(300);
        assertEquals(300, drone.getBatteryCapacity());
    }

    @Test
    void setState() {
        drone.setState(DroneState.LOADED);
        assertEquals(DroneState.LOADED, drone.getState());
    }

    @Test
    void getState() {
        drone.setState(DroneState.LOADED);
        assertEquals(DroneState.LOADED, drone.getState());
    }

    @Test
    void testToString() {
        assertEquals("Drone{" +
                "serialNumber='" + drone.getSerialNumber() + '\'' +
                ", model=" + drone.getModel() +
                ", weightLimit=" + drone.getWeightLimit() +
                ", batteryCapacity=" + drone.getBatteryCapacity() +
                ", state=" + drone.getState() +
                '}',drone.toString());
    }
}
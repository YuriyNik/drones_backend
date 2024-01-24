package com.drones.drones_backend.model;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "event_log")
public class EventLog {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "drone_serial_number", referencedColumnName = "serial_number")
    private Drone drone;
    private String eventType;
    private int eventDetail; //  battery level
    private LocalDateTime timestamp;

    public EventLog(Drone drone, String eventType, int eventDetail) {
        this.drone = drone;
        this.eventType = eventType;
        this.eventDetail = eventDetail;
        this.timestamp = LocalDateTime.now();
    }

    public EventLog() {
    }

    @Override
    public String toString() {
        return "EventLog{" +
                "id=" + id +
                ", drone.serialNumber='" + drone.getSerialNumber() + '\'' +
                ", eventType='" + eventType + '\'' +
                ", eventDetail=" + eventDetail +
                ", timestamp=" + timestamp +
                '}';
    }
}

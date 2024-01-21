package com.drones.drones_backend.model;
import java.time.LocalDateTime;

public class EventLog {

    private Long id;

    private final String droneSerialNumber;
    private final String eventType;
    private final int eventDetail; //  battery level
    private final LocalDateTime timestamp;

    public EventLog(String droneSerialNumber, String eventType, int eventDetail) {
        this.droneSerialNumber = droneSerialNumber;
        this.eventType = eventType;
        this.eventDetail = eventDetail;
        this.timestamp = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "EventLog{" +
                "id=" + id +
                ", droneSerialNumber='" + droneSerialNumber + '\'' +
                ", eventType='" + eventType + '\'' +
                ", eventDetail=" + eventDetail +
                ", timestamp=" + timestamp +
                '}';
    }
}

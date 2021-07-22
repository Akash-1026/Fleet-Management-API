package org.akash.Entity;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class Alerts {

    @Id
    String id;
    @ManyToOne
    @JoinColumn(name = "vin", nullable = false)
    Vehicle vehicle;
    String timeStamp;
    String alertReason;
    @Enumerated(EnumType.STRING)
    Priority status;

    public Alerts(){
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getAlertReason() {
        return alertReason;
    }

    public void setAlertReason(String alertReason) {
        this.alertReason = alertReason;
    }

    public Priority getStatus() {
        return status;
    }

    public void setStatus(Priority status) {
        this.status = status;
    }
}

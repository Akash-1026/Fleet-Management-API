package org.akash.Entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Entity
public class Vehicle {

    @Id
    @Column( columnDefinition = "VARCHAR(36)" )
    private String vin;

    @Column( columnDefinition = "VARCHAR(20)" )
    private String make;

    @Column( columnDefinition = "VARCHAR(20)" )
    private String model;

    private int year;
    private int redlineRpm;
    private float maxFuelVolume;

    private Date lastServiceDate;



    @OneToMany(mappedBy = "vehicle")
    private List<Readings> readings;
    @OneToMany(mappedBy = "vehicle")
    private List<Alerts> alerts;


    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getRedlineRpm() {
        return redlineRpm;
    }

    public void setRedlineRpm(int redlineRpm) {
        this.redlineRpm = redlineRpm;
    }

    public float getMaxFuelVolume() {
        return maxFuelVolume;
    }

    public void setMaxFuelVolume(float maxFuelVolume) {
        this.maxFuelVolume = maxFuelVolume;
    }

    public Date getLastServiceDate() {
        return lastServiceDate;
    }

    public void setLastServiceDate(Date lastServiceDate) {
        this.lastServiceDate = lastServiceDate;
    }
}

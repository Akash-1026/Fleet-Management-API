package org.akash.DTO;


import org.akash.Entity.Tires;

public class ReadingsDTO {
    private String vin;
    private double latitutde;
    private double longitude;
    private String timestamp;
    private float fuelVolume;
    private float speed;
    private int engineHp;
    private boolean checkEngineLightOn;
    private boolean engineCoolantLow;
    private boolean cruiseControlOn;
    private int engineRpm;
    private Tires tires;

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public double getLatitutde() {
        return latitutde;
    }

    public void setLatitutde(double latitutde) {
        this.latitutde = latitutde;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public float getFuelVolume() {
        return fuelVolume;
    }

    public void setFuelVolume(float fuelVolume) {
        this.fuelVolume = fuelVolume;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public int getEngineHp() {
        return engineHp;
    }

    public void setEngineHp(int engineHp) {
        this.engineHp = engineHp;
    }

    public boolean isCheckEngineLightOn() {
        return checkEngineLightOn;
    }

    public void setCheckEngineLightOn(boolean checkEngineLightOn) {
        this.checkEngineLightOn = checkEngineLightOn;
    }

    public boolean isEngineCoolantLow() {
        return engineCoolantLow;
    }

    public void setEngineCoolantLow(boolean engineCoolantLow) {
        this.engineCoolantLow = engineCoolantLow;
    }

    public boolean isCruiseControlOn() {
        return cruiseControlOn;
    }

    public void setCruiseControlOn(boolean cruiseControlOn) {
        this.cruiseControlOn = cruiseControlOn;
    }

    public int getEngineRpm() {
        return engineRpm;
    }

    public void setEngineRpm(int engineRpm) {
        this.engineRpm = engineRpm;
    }

    public Tires getTires() {
        return tires;
    }

    public void setTires(Tires tires) {
        this.tires = tires;
    }
}

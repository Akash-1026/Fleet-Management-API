package org.akash.Service;

import org.akash.DTO.ReadingsDTO;
import org.akash.Entity.*;
import org.akash.Exception.ResourceNotFoundException;
import org.akash.Repository.AlertsRepository;
import org.akash.Repository.ReadingsRepository;
import org.akash.Repository.TiresRepository;
import org.akash.Repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;
import java.util.PriorityQueue;

@Service
public class ReadingsServiceImpl implements ReadingsService{

    @Autowired
    ReadingsRepository readingsRepository;
    @Autowired
    VehicleRepository vehicleRepository;
    @Autowired
    TiresRepository tiresRepository;
    @Autowired
    AlertsRepository alertsRepository;

    @Override
    public void  createReading(ReadingsDTO reading) throws ResourceNotFoundException {
        Tires tire = tiresRepository.save(reading.getTires());
        Readings readings = new Readings();
        readings.setCheckEngineLightOn(reading.isCheckEngineLightOn());
        readings.setCruiseControlOn(reading.isCruiseControlOn());
        readings.setEngineHp(reading.getEngineHp());
        readings.setEngineRpm(reading.getEngineRpm());
        readings.setFuelVolume(reading.getFuelVolume());
        readings.setSpeed(reading.getSpeed());
        readings.setTire(tire);
        readings.setLatitutde(reading.getLatitutde());
        readings.setLongitude(reading.getLongitude());
        readings.setEngineCoolantLow(reading.isEngineCoolantLow());
        readings.setTimestamp(reading.getTimestamp());
        Optional<Vehicle> vehicle = vehicleRepository.findByVin(reading.getVin());
        if(vehicle.isPresent()){
            readings.setVehicle(vehicle.get());
        }else{
            throw new ResourceNotFoundException("Vehicle by vin :"+ reading.getVin()+" does'nt exist");
        }

        //Check for Alerts
        rpmCheck(vehicle.get(), reading);
        fuelCheck(vehicle.get(), reading);
        engineCheck(vehicle.get(), reading);
        tirePressureCheck(vehicle.get(), reading, tire);


        readingsRepository.save(readings);
    }

    private void tirePressureCheck(Vehicle vehicle, ReadingsDTO reading, Tires tire) {
        if(tire.getFrontLeft() < 32 || tire.getFrontRight() < 32 || tire.getRearLeft() < 32 || tire.getRearRight() < 32
           || tire.getFrontLeft() > 36 || tire.getFrontRight() > 36 || tire.getRearLeft() > 36 || tire.getRearRight() > 36){
            createAlert(vehicle, "Please check tire pressure",Priority.LOW,reading.getTimestamp());
        }
    }

    public void rpmCheck(Vehicle vehicle,ReadingsDTO reading){
        if(vehicle.getRedlineRpm() < reading.getEngineRpm()){
            createAlert(vehicle,"Vehicle has exceeded the RPM",Priority.HIGH,reading.getTimestamp());
        }
    }
    public void fuelCheck(Vehicle vehicle,ReadingsDTO reading){
        float capacity = vehicle.getMaxFuelVolume();
        if(reading.getFuelVolume() < (capacity * 0.1)){
            createAlert(vehicle, "Fuel volume belowe 10%",Priority.MEDIUM, reading.getTimestamp());
        }
    }
    public void engineCheck(Vehicle vehicle,ReadingsDTO reading){
        if(reading.isCheckEngineLightOn()){
            createAlert(vehicle, "Engine light is on",Priority.LOW, reading.getTimestamp());
        }else if(reading.isEngineCoolantLow()){
            createAlert(vehicle, "Engine Coolant is low",Priority.LOW, reading.getTimestamp());
        }
    }

    public void createAlert(Vehicle vehicle,String reason, Priority status, String timeStamp){
        Alerts alert = new Alerts();
        alert.setVehicle(vehicle);
        alert.setAlertReason(reason);
        alert.setStatus(status);
        alert.setTimeStamp(timeStamp);
        alertsRepository.save(alert);
    }

    @Override
    public Optional<Readings> getReadingsByVin(String vin) throws ResourceNotFoundException {
        Optional<Readings> readings = readingsRepository.findByVehicle(vin);
        if(readings.isEmpty()) {
            throw new ResourceNotFoundException("Vehicle with vin : "+vin+" doesn't exist");
        } else
        return readings;
    }
}

package org.akash.Service;

import org.akash.Entity.Vehicle;
import org.akash.Repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService{
    @Autowired
    VehicleRepository vehicleRepository;
    @Override
    public void upsertVehicle(List<Vehicle> vehicles) {
        vehicles.stream().forEach(vehicle -> vehicleRepository.save(vehicle));
    }

    @Override
    public Iterable<Vehicle> getAllVehicle() {
        return vehicleRepository.findAll();
    }
}

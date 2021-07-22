package org.akash.Service;

import org.akash.Entity.Vehicle;
import org.springframework.stereotype.Service;

import java.util.List;

public interface VehicleService {
    public void upsertVehicle(List<Vehicle> vehicle);
    public Iterable<Vehicle> getAllVehicle();
}

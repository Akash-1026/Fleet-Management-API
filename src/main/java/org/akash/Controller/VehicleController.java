package org.akash.Controller;

import org.akash.Entity.Vehicle;
import org.akash.Service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "vehicles")
public class VehicleController {
    @Autowired
    VehicleService vehicleService;

    @RequestMapping(method = RequestMethod.PUT)
    public void putVehicle(@RequestBody List<Vehicle> vehicles){

        for(Vehicle vehicle: vehicles)
        vehicleService.upsertVehicle(vehicles);
    }

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Vehicle> getAllVehicle(){
        return vehicleService.getAllVehicle();
    }
}

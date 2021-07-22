package org.akash.Repository;

import org.akash.Entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle,String> {
    Optional<Vehicle> findByVin(String vin);
}

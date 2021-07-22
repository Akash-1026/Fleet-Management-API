package org.akash.Repository;

import org.akash.Entity.Readings;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReadingsRepository extends CrudRepository<Readings,String> {
    public Optional<Readings> findByVehicle(String vin);
}

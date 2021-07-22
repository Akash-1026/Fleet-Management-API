package org.akash.Service;

import org.akash.DTO.ReadingsDTO;
import org.akash.Entity.Readings;
import org.akash.Exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

public interface ReadingsService {
    public void createReading(ReadingsDTO reading) throws ResourceNotFoundException;
    public Optional<Readings> getReadingsByVin(String vin) throws ResourceNotFoundException;
}

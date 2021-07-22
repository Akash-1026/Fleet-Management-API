package org.akash.Controller;

import org.akash.DTO.ReadingsDTO;
import org.akash.Exception.ResourceNotFoundException;
import org.akash.Service.ReadingsService;
import org.akash.Service.ReadingsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RequestMapping(value = "readings")
@RestController
public class ReadingController {

    @Autowired
    ReadingsService readingsService;

    @RequestMapping(method = RequestMethod.POST)
    public void createReadings(@RequestBody ReadingsDTO reading) throws ResourceNotFoundException {
        readingsService.createReading(reading);
    }
}

package org.akash.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.akash.Entity.Readings;
import org.akash.Entity.Tires;
import org.akash.Entity.Vehicle;
import org.akash.Repository.ReadingsRepository;
import org.akash.Service.ReadingsService;
import org.akash.Service.ReadingsServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.MOCK
)
@AutoConfigureWebMvc
@AutoConfigureMockMvc
@ActiveProfiles("integrationtest")
class ReadingControllerTest {
    @Autowired
    ObjectMapper mapper;
    @Autowired
    private MockMvc mvc; //just like postman
    @Test
    void createReadings(){

        Vehicle vehicle = new Vehicle();
        vehicle.setVin("1HGCR2F3XFA027534");
        vehicle.setLastServiceDate(new Date());
        vehicle.setMake("HONDA");
        vehicle.setModel("ACCORD");
        vehicle.setYear(2015);
        vehicle.setMaxFuelVolume(15);
        vehicle.setRedlineRpm(5500);

        Readings reading = new Readings();
        Tires tire = new Tires();
        tire.setFrontLeft(34);
        tire.setFrontRight(36);
        tire.setRearLeft(29);
        tire.setRearRight(34);


        reading.setVehicle(vehicle);
        reading.setLatitutde(41.803194);
        reading.setLongitude(-88.144406);
        reading.setTimestamp("2017-05-25T17:31:25.268Z");
        reading.setFuelVolume(1.5F);
        reading.setSpeed(85);
        reading.setEngineHp(240);
        reading.setCheckEngineLightOn(false);
        reading.setEngineCoolantLow(true);
        reading.setCruiseControlOn(true);
        reading.setEngineRpm(6300);
        reading.setTire(tire);

        try {
            mvc.perform(MockMvcRequestBuilders.post("/readings").contentType(MediaType.APPLICATION_JSON).content(mapper.writeValueAsBytes(reading))).andExpect(MockMvcResultMatchers.status().isOk());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
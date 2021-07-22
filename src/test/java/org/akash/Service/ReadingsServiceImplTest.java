//package org.akash.Service;
//
//import org.akash.Entity.Readings;
//import org.akash.Entity.Tires;
//import org.akash.Entity.Vehicle;
//import org.akash.Exception.ResourceNotFoundException;
//import org.akash.Repository.ReadingsRepository;
//import org.akash.Repository.TiresRepository;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.TestConfiguration;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//import java.util.Date;
//import java.util.Optional;
//
//@ExtendWith(SpringExtension.class)
//class ReadingsServiceImplTest {
//    @TestConfiguration
//    static class ReadingServiceImplTestConfig{
//        @Bean
//        public ReadingsService getService() {
//            return new ReadingsServiceImpl();
//        }
//    }
//
//    @Autowired
//    ReadingsService readingsService;
//
//    @MockBean
//    ReadingsRepository readingsRepository;
//    @MockBean
//    TiresRepository tiresRepository;
//    private Readings reading;
//    @BeforeEach
//    void setUp() {
//
//        Vehicle vehicle = new Vehicle();
//        vehicle.setVin("1HGCR2F3XFA027534");
//        vehicle.setLastServiceDate(new Date());
//        vehicle.setMake("HONDA");
//        vehicle.setModel("ACCORD");
//        vehicle.setYear(2015);
//        vehicle.setMaxFuelVolume(15);
//        vehicle.setRedlineRpm(5500);
//
//        reading = new Readings();
//        Tires tire = new Tires();
//        tire.setFrontLeft(34);
//        tire.setFrontRight(36);
//        tire.setRearLeft(29);
//        tire.setRearRight(34);
//
//
//        reading.setVehicle(vehicle);
//        reading.setLatitutde(41.803194);
//        reading.setLongitude(-88.144406);
//        reading.setTimestamp("2017-05-25T17:31:25.268Z");
//        reading.setFuelVolume(1.5F);
//        reading.setSpeed(85);
//        reading.setEngineHp(240);
//        reading.setCheckEngineLightOn(false);
//        reading.setEngineCoolantLow(true);
//        reading.setCruiseControlOn(true);
//        reading.setEngineRpm(6300);
//        reading.setTire(tire);
//
//        Mockito.when(readingsRepository.findByVin("1HGCR2F3XFA027534")).thenReturn(Optional.of(reading));
//
//    }
//
//    @Test
//    void getReadingsByVin() throws ResourceNotFoundException {
//        Optional<Readings> res = readingsService.getReadingsByVin("1HGCR2F3XFA027534");
//        Assertions.assertEquals(reading,res.get(),"Find by ID does not match");
//    }
//}
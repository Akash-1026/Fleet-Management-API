//package org.akash.Service;
//
//import org.akash.Entity.Vehicle;
//import org.akash.Repository.VehicleRepository;
//import org.junit.jupiter.api.AfterEach;
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
//import java.util.*;
//
//@ExtendWith(SpringExtension.class)
//class VehicleServiceImplTest {
//
//    @TestConfiguration
//    static class VehicleServiceImplTestConfig{
//        @Bean
//        public VehicleService getService() {
//            return new VehicleServiceImpl();
//        }
//    }
//    @Autowired
//    VehicleService vehicleService;
//
//    @MockBean
//    VehicleRepository vehicleRepository;
//    private List<Vehicle> list;
//    @BeforeEach
//    void setUp() {
//        Vehicle vehicle = new Vehicle();
//        vehicle.setVin("1HGCR2F3XFA027534");
//        vehicle.setLastServiceDate(new Date());
//        vehicle.setMake("HONDA");
//        vehicle.setModel("ACCORD");
//        vehicle.setYear(2015);
//        vehicle.setMaxFuelVolume(15);
//        vehicle.setRedlineRpm(5500);
//        list = new ArrayList<>();
//        list.add(vehicle);
//
//        Mockito.when(vehicleRepository.findAll())
//                .thenReturn(list);
//    }
//
//    @AfterEach
//    void tearDown() {
//    }
//
//    @Test
//    void upsertVehicle() {
//    }
//
//    @Test
//    void getAllVehicle() {
//        Iterable<Vehicle> res = vehicleService.getAllVehicle();
//        Assertions.assertEquals(list,res,"list of vehicles does not match");
//    }
//}
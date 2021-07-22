package org.akash.Service;

import org.akash.Entity.Employee;
import org.akash.Repository.EmployeeRepo;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;


import java.util.Collections;
import java.util.List;


@ExtendWith(SpringExtension.class)
class EmployeeServiceImplTest {

    @TestConfiguration
    static class EmployeeServiceImplTestConfiguration{
        @Bean
        public EmployeeService getService() {
            return new EmployeeServiceImpl();
        }
    }

    @Autowired
    private EmployeeService employeeService;

    @MockBean
    private EmployeeRepo employeeRepo;

    @Before("")
    public void before(){
        System.out.println("Before Cleanup");
        //when
//        Mockito.when( )
        //return
    }

    @After("")
    public void cleanUp(){
        System.out.println("clean up test");
    }

    @Test
    void getAll() {
        List<Employee> result = employeeService.getAll();
        Assertions.assertEquals(Collections.EMPTY_LIST,result,"List does not match");
//        Assertions.assertEquals();
    }

    @Test
    void findOne() {
    }

    @Test
    void create() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }
}
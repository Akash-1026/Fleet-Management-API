//package org.akash.Controller;
//
//import org.akash.Entity.Employee;
//import org.akash.Service.EmployeeService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//@RequestMapping(value = "employees")
//public class EmployeeController {
//    @Autowired
//    private EmployeeService employeeService;
//
//    @GetMapping
//    public List<Employee> getAll(){
//        return employeeService.getAll();
//    }
//
//    @RequestMapping(method = RequestMethod.GET,value = "{id}")
//    public Optional<Employee> findOne(@PathVariable("id") String id){
//        return employeeService.findOne(id);
//    }
//
//    @RequestMapping(method = RequestMethod.POST)
//    public Employee create(@RequestBody Employee e){
//        return employeeService.create(e);
//    }
//
//    @RequestMapping(method = RequestMethod.PUT,value = "{id}")
//    public Employee update(@PathVariable("id") String id,@RequestBody Employee e){
//        return employeeService.update(id,e);
//    }
//
//    @RequestMapping(method = RequestMethod.DELETE,value = "{id}")
//    public void delete(@PathVariable("id") String id){
//        employeeService.delete(id);
//    }
//}

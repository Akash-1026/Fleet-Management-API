package org.akash.Service;

import org.akash.Entity.Employee;
import org.akash.Repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    private EmployeeRepo employeeRepo;

    @Override
    public List<Employee> getAll() {
        return (List<Employee>) employeeRepo.findAll();
    }

    @Override
    public Optional<Employee> findOne(String id) {
        return employeeRepo.findById(id);
    }

    @Override
    public Employee create(Employee e) {
        return employeeRepo.save(e);
    }

    @Override
    public Employee update(String id, Employee e) {
        return employeeRepo.save(e);
    }

    @Override
    public void delete(String id) {
        employeeRepo.deleteById(id);
    }
}

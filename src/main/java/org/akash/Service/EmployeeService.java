package org.akash.Service;

import org.akash.Entity.Employee;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
@Component
public interface EmployeeService {
    public List<Employee> getAll();
    public Optional<Employee> findOne(String id);
    public Employee create(Employee e);
    public Employee update(String id, Employee e);
    public void delete(String id);
}

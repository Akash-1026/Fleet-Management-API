package org.akash.Repository;

import org.akash.Entity.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepo extends CrudRepository<Employee, String> {
}
